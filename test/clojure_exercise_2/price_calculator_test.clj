(ns clojure-exercise-2.price-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.price-calculator :refer :all]
            [clojure-exercise-2.plans :refer :all]))

(facts "Testing price calculator with thresholds"
       (fact "Testing expected values with eon"
             (threshold-consumption-price (:rates plan1) 0M) => 0M
             (threshold-consumption-price (:rates plan1) 99M) => 1336.5M
             (threshold-consumption-price (:rates plan1) 1000M) => 10350M
             (threshold-consumption-price (:rates plan1) 1200M) => 12350M)

       (fact "Testing expected values with ovo"
             (threshold-consumption-price (:rates plan2) 0M) => 0M
             (threshold-consumption-price (:rates plan2) 299M) => 3737.5M
             (threshold-consumption-price (:rates plan2) 1000M) => 11450M
             (threshold-consumption-price (:rates plan2) 1200M) => 13650M)

       (fact "Testing expected values with edf"
             (threshold-consumption-price (:rates plan3) 0M) => 0M
             (threshold-consumption-price (:rates plan3) 249M) => 3610.5M
             (threshold-consumption-price (:rates plan3) 449M) => 5634.9M
             (threshold-consumption-price (:rates plan3) 1000M) => 10595M
             (threshold-consumption-price (:rates plan3) 1200M) => 12395M)

       (fact "Testing expected values with bg"
             (threshold-consumption-price (:rates plan4) 0M) => 0M
             (threshold-consumption-price (:rates plan4) 1000M) => 9000M
             (threshold-consumption-price (:rates plan4) 1200M) => 10800M))