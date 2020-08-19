(ns clojure-exercise-2.price-calculator
  (:require [clojure-exercise-2.plans :refer :all]))

(def vat 0.05M)

(defn- consumption-price
  "Returns the charge value with the price and consumption given"
  [price consumption]
  (* price consumption))

(defn- threshold-consumption-price
  "Returns the price calculating the consumption for each threshold given (as a map)"
  [plan-thresholds consumption]
  (loop [head (first plan-thresholds)
         tail (rest plan-thresholds)
         kwh consumption
         charge 0]
          ;;If kwh is 0 or less, finish and return the charge
    (cond (<= kwh 0) charge

          ;;If kwh is lesser than the threshold or if there is no threshold, finish adding the price and return the charge
          (or (empty? tail) (< kwh (:threshold head))) (+ charge (consumption-price (:price head) kwh))

          ;;If kwh is bigger than the threshold, calculate the price and prepare for the next loop
          :else (recur (first tail)
                       (rest tail)
                       (- kwh (:threshold head))
                       (+ charge (consumption-price (:price head) (:threshold head)))))))

(defn- add-standing-charge
  "Adds the standing charge * 365 to the price"
  [standing-charge price]
  (+ price (* standing-charge 365)))

(defn- add-vat
  "Returns the price rounded with VAT added to it"
  [price]
  (+ price (* price vat)))

(defn annual-price
  "Given a plan and consumption, calculates the price using the plan data"
  [plan consumption]
  (->> (threshold-consumption-price (:rates plan) consumption)
       (add-standing-charge (:standing_charge plan 0))
       (add-vat)))