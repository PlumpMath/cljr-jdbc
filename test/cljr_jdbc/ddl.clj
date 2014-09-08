(ns cljr-jdbc.ddl
  (:require [cljr-jdbc.config :refer :all]
            [clojure.java.jdbc :as j]))

(j/db-do-commands
 (db-connection)
 (try
   (j/drop-table-ddl :forretningsomraade)
   (catch Exception _))
 (j/create-table-ddl :forretningsomraade
                     [:id :serial "PRIMARY KEY"]
                     [:forretningsomraade "number" "NOT NULL" "UNIQUE"]
                     [:navn "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:kortnavn "varchar(80)" "NOT NULL" "UNIQUE"])

 (try
   (j/drop-table-ddl :produktlinje)
   (catch Exception _))
 (j/create-table-ddl :produktlinje
                     [:id :serial "PRIMARY KEY"]
                     [:produktlinje "number" "NOT NULL" "UNIQUE"]
                     [:navn "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:forretningsomraade "number" "NOT NULL" "REFERENCES FORRETNINGSOMRAADE(FORRETNINGSOMRAADE)"])

 (try
   (j/drop-table-ddl :produktgruppetype)
   (catch Exception _))
 (j/create-table-ddl :produktgruppetype
                     [:id :serial "PRIMARY KEY"]
                     [:produktgruppetype "number" "NOT NULL" "UNIQUE"]
                     [:navn "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:kortnavn "varchar(80)" "NOT NULL" "UNIQUE"])

 (try
   (j/drop-table-ddl :produktgruppe)
   (catch Exception _))
 (j/create-table-ddl :produktgruppe
                     [:id :serial "PRIMARY KEY"]
                     [:produktgruppe "number" "NOT NULL" "UNIQUE"]
                     [:navn "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:produktkode "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:minimum "number" "NOT NULL"]
                     [:produktgruppetype "number" "NOT NULL" "REFERENCES PRODUKTGRUPPETYPE (PRODUKTGRUPPETYPE)"]
                     [:produktlinje "number" "NOT NULL" "REFERENCES PRODUKTLINJE (PRODUKTLINJE)"]
                     [:forretningsomraade "number" "NOT NULL" "REFERENCES FORRETNINGSOMRAADE (FORRETNINGSOMRAADE)"])

 (try
   (j/drop-table-ddl :service)
   (catch Exception _))
 (j/create-table-ddl :service
                     [:id :serial "PRIMARY KEY"]
                     [:navn "varchar(80)" "NOT NULL" "UNIQUE"]
                     [:type "varchar(80)" "NOT NULL"]
                     [:servicegruppe "varchar(80)"]
                     [:tjeneste "varchar(80)"]
                     [:provkode "varchar(80)"]
                     [:iriskode "varchar(80)"]
                     [:prisaendring "number"]))
