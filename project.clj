(defproject clojure-exercise-2 "0.1.0-SNAPSHOT"
  :description "A Clojure skill test"
  :url "https://lsouza.sleek.page"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [midje "1.9.9"]
                 [org.clojure/data.json "1.0.0"]]
  :plugins [[lein-midje "3.2.1"]
            [lein-cloverage "1.2.0"]]
  :repl-options {:init-ns clojure-exercise-2.core}
  :main clojure-exercise-2.core/-main)
