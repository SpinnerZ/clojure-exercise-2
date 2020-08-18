(ns clojure-exercise-2.core
    (:gen-class))

(def plan1 {:supplier "eon"
            :plan "variable"
            :rates [{:price 13.5 :threshold 100}
                    {:price 10}]
            :standing_charge 0})

(def plan2 {:supplier "ovo"
            :plan "standard"
            :rates [{:price 12.5 :threshold 300}
                    {:price 11}]
            :standing_charge 0})

(def plan3 {:supplier "edf"
            :plan "fixed"
            :rates [{:price 14.5 :threshold 250}
                    {:price 10.1 :threshold 200}
                    {:price 9}]
            :standing_charge 0})

(def plan4 {:supplier "bg"
            :plan "standing-charge"
            :rates [{:price 9}]
            :standing_charge 7})