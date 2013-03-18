(ns enterpriceless.api
  (:require [noirie.json :refer :all]))

(defonce users (atom {}))
(defonce ids   (atom 0))

(defjson [:get "/api/users"] {} @users)

(defjson [:get "/api/users/:id"] {id :id} (@users id))

(defjson [:delete "/api/users/:id"] {id :id} (swap! users dissoc id))

(defjson [:post "/api/users"] {json :json}
  (let [id   (str (swap! ids inc))
        user (assoc json :id id)]
    (swap! users assoc id user)
    user))
