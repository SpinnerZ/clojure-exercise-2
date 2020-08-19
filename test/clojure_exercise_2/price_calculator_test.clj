(ns clojure-exercise-2.price-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.price-calculator :refer :all]))

(facts "Testing add-vat"
       (fact "Testing expected values"
             (add-vat 100M) => 105M
             (add-vat 28.7M) => 30.135M
             (add-vat 56.6M) => 59.43M
             (add-vat 45.58M) => 47.859M
             (add-vat 36.47M) => 38.2935M
             (add-vat 29.38M) => 30.849M
             (add-vat 14.13M) => 14.8365M
             (add-vat 85.83M) => 90.1215M))