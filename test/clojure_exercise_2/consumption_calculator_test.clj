(ns clojure-exercise-2.consumption-calculator-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise-2.plans :as plans]
            [clojure-exercise-2.consumption-calculator :refer :all]))

(facts "Testing consumption calculator"
       (fact "Test with example values"
             (annual-usage plans/plan3 35000) => 44267
             (annual-usage plans/plan2 100000) => 103855
             (annual-usage plans/plan4 12000) => 14954)

       (fact "Test with 0"
             (annual-usage plans/plan1 0) => 0
             (annual-usage plans/plan2 0) => 0
             (annual-usage plans/plan3 0) => 0
             (annual-usage plans/plan4 0) => 0))