(ns clojure-exercise-2.consumption-calculator)

(defn- rem-vat
  "Removes the VAT from a price"
  [price]
  (/ price 1.05M))

(defn- rem-standing-charge
  "Removes the standing-charge from a MONTHLY price"
  [standing-charge price]
  (- price (* standing-charge 30M)))

(defn- monthly-price->annual-price
  "Returns the price * 12"
  [price]
  (* price 12M))

(defn- price-threshold->consumption
  "Given a price and the thresholds of a plan, returns the consumption"
  [thresholds charge]
  (loop [head (first thresholds)
         tail (rest thresholds)
         consumption 0
         spend charge]

          ;;Spend zero means end
    (cond (<= spend 0) consumption

          ;;If there is no tail, no need to check threshold anymore.
          ;;If the spend is lesser than the threshold max price, means that it's the last iteration.
          (or (empty? tail)
              (< spend (* (:threshold head)
                          (:price head))))
          (+ consumption (/ spend (:price head)))

          ;;If the price is higher than the threshold, there is more work to do
          :else (recur (first tail)
                       (rest tail)
                       (+ consumption (:threshold head))
                       (- spend
                          (* (:price head)
                             (:threshold head)))))))

(defn annual-usage
  "Receives the plan and value spend in a month and calculates how much energy would be used annually"
  [plan spend]
  (if (zero? spend)
    spend
    (->> (rem-vat spend)
         (rem-standing-charge (:standing_charge plan 0))
         (monthly-price->annual-price)
         (with-precision 12)
         (price-threshold->consumption (:rates plan)))))