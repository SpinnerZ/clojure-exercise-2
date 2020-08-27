(ns clojure-exercise-2.core
    (:require [clojure-exercise-2.price-calculator :as price]
              [clojure-exercise-2.consumption-calculator :as consumption]
              [clojure.data.json :as json]
              [clojure.string :as str])
    (:gen-class))

(defn- load-plans
  "Reads the json input and puts in memory as a map"
  [path]
  (json/read-str (slurp path) :key-fn keyword))

(def all-plans (load-plans "resources/plans.json"))

(defn- single-price-consumption
  "Returns the supplier, plan and total cost from an annual consumption"
  [consumption plan]
  {:supplier (:supplier plan)
   :plan (:plan plan)
   :total-cost (price/annual-price plan consumption)})

(defn- all-plans-price-consumption
  "Gets all plans price given a consumption input, sorting them by cheapest first"
  [plans consumption]
  (sort-by :total-cost (map (partial single-price-consumption consumption) plans)))

(defn- print-prices
  "Prints to console the supplier, plan and total-cost from given seq or unique map"
  [plans]
  (run! #(println
          (str (:supplier %) ","
               (:plan %) ","
               (.setScale
                  (with-precision 12 (/ (:total-cost %) 100M))
                  2
                  java.math.RoundingMode/HALF_UP)))
        plans))

(defn- print-consumption
  "Prints to console the kWh of a given plan and price"
  [plan spend]
  (println (consumption/annual-usage plan (* spend 100))))

(def print-prices-all-plans (comp print-prices (partial all-plans-price-consumption all-plans)))

(defn -main
  "nuSwitch Energy Comparison"
  []
  (loop [input (str/split (read-line) #" ")]
        (let [command (first input)
              values (rest input)]
          (condp = command
           "price" (do (print-prices-all-plans (Integer/parseInt (first values)))
                       (flush)
                       (recur (str/split (read-line) #" ")))
           "usage" (do (print-consumption (first (filter #(= (first values) (:supplier %))
                                                  all-plans))
                                          (Integer/parseInt (last values)))
                       (flush)
                       (recur (str/split (read-line) #" ")))
           "exit" nil))))
