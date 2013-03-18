(ns enterpriceless.server
  (:require [noir.server :as server]
            [enterpriceless.api]
            [noirie.json :as json])
  (:gen-class))

(defn -main [& m]
  (server/add-middleware json/wrap-json-params)
  (server/start 8080 {:mode :dev}))
