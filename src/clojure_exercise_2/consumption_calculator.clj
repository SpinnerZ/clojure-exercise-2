(ns clojure-exercise-2.consumption-calculator)

(def vat 1.05M)

(defn- rem-vat
  "Removes the VAT from a price"
  [price]
  (/ price vat))

(defn- rem-standing-charge
  "Removes the standing-charge from a MONTHLY price"
  [standing-charge price]
  (- price (standing-charge * 30M)))

(defn- monthly-price->annual-price
  "Returns the price * 12"
  [price]
  (* price 12M))

(defn- price-threshold->consumption
  "Given a price and the thresholds of a plan, returns the consumption"
  [thresholds price]
  )