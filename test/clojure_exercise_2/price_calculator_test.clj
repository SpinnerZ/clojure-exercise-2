(ns clojure-exercise-2.price-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.price-calculator :refer :all]))

(facts "Testing each function"
       (fact "Testing 5% VAT prices"
             (add-vat 100) => 105
             (add-vat 28.7) => 30.14
             (add-vat 56.6) => 59.43
             (add-vat 45.58) => 47.86
             (add-vat 36.47) => 38.3
             (add-vat 29.38) => 30.85
             (add-vat 14.13) => 14.84
             (add-vat 85.83) => 90.13))