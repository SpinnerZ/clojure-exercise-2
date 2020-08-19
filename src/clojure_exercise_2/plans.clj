(ns clojure-exercise-2.plans)

(def plan1 {:supplier "eon"
            :plan "variable"
            :rates [{:price 13.5M :threshold 100M}
                    {:price 10M}]
            :standing_charge 0M})

(def plan2 {:supplier "ovo"
            :plan "standard"
            :rates [{:price 12.5M :threshold 300M}
                    {:price 11M}]
            :standing_charge 0M})

(def plan3 {:supplier "edf"
            :plan "fixed"
            :rates [{:price 14.5M :threshold 250M}
                    {:price 10.1M :threshold 200M}
                    {:price 9M}]
            :standing_charge 0M})

(def plan4 {:supplier "bg"
            :plan "standing-charge"
            :rates [{:price 9M}]
            :standing_charge 7M})