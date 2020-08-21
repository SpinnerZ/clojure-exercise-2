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

