(ns noirie.json
  (:require [noir.core :refer [defpage]]
            [noir.response :as res]
            [cheshire.core :as json]))

(defmacro defjson [path params & content]
  `(defpage ~path ~params
     (res/json (do ~@content))))

(defn wrap-json-params [handler]
  (fn [request]
    (handler
      (if (not (empty? (re-find #"^application/(vnd.+)?json" (get-in request [:headers "content-type"] ""))))
        (update-in request [:params] assoc :json (json/parse-string (slurp (:body request)) true))
        request))))
