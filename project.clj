(defproject domina-test "0.1.0-SNAPSHOT"
  
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [reagent "0.4.3"]
                 [domina "1.0.3-SNAPSHOT"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  
  :plugins      [[lein-cljsbuild "1.0.3"]]

  :cljsbuild    {:builds 
                 {:domina-test
                  {:source-paths ["src"]
                   :compiler
                   {:preamble ["reagent/react.js"]
                    :output-to "target/domina-test.js"
                    :output-dir "target/out"
                    :optimizations :simple 
                    :source-map "target/domina-test.js.map"}}}}
  
  :aliases      {
                 "bj" ["do" "clean" ["cljsbuild" "once"]]
                 }
  )
