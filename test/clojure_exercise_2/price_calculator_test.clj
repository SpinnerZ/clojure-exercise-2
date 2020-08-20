(ns clojure-exercise-2.price-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.price-calculator :refer :all]
            [clojure-exercise-2.plans :as plans]))

(facts "Testing price-calculator"
       (fact "Testing expected values with eon"
             (annual-price plans/plan1 0) => 0M
             (annual-price plans/plan1 99) => 1403.325M
             (annual-price plans/plan1 1000) => 10867.5M
             (annual-price plans/plan1 2000) => 21367.5M)

       (fact "Testing expected values with ovo"
             (annual-price plans/plan2 0) => 0M
             (annual-price plans/plan2 299) => 3924.375M
             (annual-price plans/plan2 1000) => 12022.5M
             (annual-price plans/plan2 2000) => 23572.5M)

       (fact "Testing expected values with edf"
             (annual-price plans/plan3 0) => 0M
             (annual-price plans/plan3 249) => 3791.025M
             (annual-price plans/plan3 449) => 5916.645M
             (annual-price plans/plan3 1000) => 11124.75M
             (annual-price plans/plan3 2000) => 20574.75M)

       (fact "Testing expected values with bg"
             (annual-price plans/plan4 0) => 2682.75M
             (annual-price plans/plan4 1000) => 12132.75M
             (annual-price plans/plan4 2000) => 21582.75M))