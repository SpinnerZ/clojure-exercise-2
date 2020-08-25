(ns clojure-exercise-2.core
    (:require [clojure-exercise-2.price-calculator :as price]
              [clojure-exercise-2.consumption-calculator :as consumption]
              [clojure.data.json :as json])
    (:gen-class))

(def plans-path "resources/plans.json")

(defn load-plans
  "Reads the json input and puts in memory as a map"
  [path]
  (json/read-str (slurp path) :key-fn keyword))

(def plans (load-plans plans-path))

(defn single-price-consumption
  "Returns the supplier, plan and total cost from an annual consumption"
  [plan consumption]
  ({:supplier (:supplier plan)
    :plan (:plan plan)
    :total-cost (price/annual-price plan consumption)}))

  (single-price-consumption (first plans) 1000)
