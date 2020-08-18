(ns clojure-exercise-2.price-calculator
  (:require [clojure-exercise-2.plans :refer :all]))

(def vat 1.045)

(defn add-vat
  "Returns the price rounded with VAT added to it"
  [price]
  (+ price (* price vat)))

(defn annual-price
  "Calculates the annual price to all plans based on annual consumption."
  [plan consumption]
  ())