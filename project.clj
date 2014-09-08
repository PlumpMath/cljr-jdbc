(defproject cljr-jdbc "0.1.0"
  :description "clojure.java.jdbc"
  :url "http://jittakal.blogspot.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/java.jdbc "0.3.3"]
                 [com.h2database/h2 "1.3.176"]
                 [com.mchange/c3p0 "0.9.2.1"]]
  :main cljr-jdbc.core)
