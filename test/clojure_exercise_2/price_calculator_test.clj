(ns clojure-exercise-2.price-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.price-calculator :refer :all]
            [clojure-exercise-2.plans :refer :all]))

(facts "Testing price-calculator"
       (fact "Testing expected values with eon"
             (annual-price plan1 0M) => 0M
             (annual-price plan1 99M) => 1403.325M
             (annual-price plan1 1000M) => 10867.5M
             (annual-price plan1 2000M) => 21367.5M)

       (fact "Testing expected values with ovo"
             (annual-price plan2 0M) => 0M
             (annual-price plan2 299M) => 3924.375M
             (annual-price plan2 1000M) => 12022.5M
             (annual-price plan2 2000M) => 23572.5M)

       (fact "Testing expected values with edf"
             (annual-price plan3 0M) => 0M
             (annual-price plan3 249M) => 3791.025M
             (annual-price plan3 449M) => 5916.645M
             (annual-price plan3 1000M) => 11124.75M
             (annual-price plan3 2000M) => 20574.75M)

       (fact "Testing expected values with bg"
             (annual-price plan4 0M) => 2682.75M
             (annual-price plan4 1000M) => 12132.75M
             (annual-price plan4 2000M) => 21582.75M))