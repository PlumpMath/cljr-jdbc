(ns cljr-jdbc.core
  (:require [cljr-jdbc.config :refer :all]
            [clojure.java.jdbc :as j]))


(comment
  (j/insert! db-spec :fruit
             {:name "Apple" :appearance "rosy" :cost 24}
             {:name "Orange" :appearance "round" :cost 49})

  (j/insert! db-spec :fruit
             {:name "Apple" :appearance "rosy" :cost 24}
             {:name "Orange" :appearance "round" :cost 49})
  ;; ({:generated_key 1} {:generated_key 2})

  (j/query db-spec
           ["select * from fruit where appearance = ?" "rosy"]
           :row-fn :cost))

(defn -main
  "Main Method"
  [& args]
  (println "Hello World!"))
