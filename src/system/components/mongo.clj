(ns system.components.mongo
  (:require [com.stuartsierra.component :as component]
            [system.common.mongo :as common]
            [schema.core :as s]
            [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

(def Options
  {(s/optional-key :connections-per-host) s/Int
   (s/optional-key :threads-allowed-to-block-for-connection-multiplier) s/Int
   (s/optional-key :max-wait-time) s/Int
   (s/optional-key :connect-timeout) s/Int
   (s/optional-key :socket-timeout) s/Int
   (s/optional-key :socket-keep-alive) s/Bool
   (s/optional-key :auto-connect-retry) s/Bool
   (s/optional-key :max-auto-connect-retry-time) s/Int})

(defrecord Mongo [uri init-fn dbname server-address server-port opts user password conn]
  component/Lifecycle
  (start [component]
    (if conn
      component
      (let [conn (common/connect component)]
        (assoc component :conn conn :db (mg/get-db conn)))))

  (stop [component]
    (when conn (try (mg/disconnect conn)
                    (catch Throwable t (println t "Error when stopping Mongo component"))))
    (dissoc component :db :conn)))

(defn new-mongo-db
  ([]
   (map->Mongo {}))
  ([uri]
   (map->Mongo {:uri uri}))
  ([uri init-fn]
   (map->Mongo {:uri uri :init-fn init-fn}))
  ([server-address server-port dbname opts]
   (map->Mongo {:server-address server-address
                :server-port server-port
                :dbname dbname
                :opts (s/validate Options opts)}))
  ([server-address server-port dbname opts user password]
   (map->Mongo {:server-address server-address
                :server-port server-port
                :dbname dbname
                :opts (s/validate Options opts)
                :user user
                :password password}))
  ([server-address server-port dbname opts init-fn]
   (map->Mongo {:server-address server-address
                :server-port server-port
                :dbname dbname
                :opts (s/validate Options opts)
                :init-fn init-fn}))
  ([server-address server-port dbname opts init-fn user password]
   (map->Mongo {:server-address server-address
                :server-port server-port
                :dbname dbname
                :opts (s/validate Options opts)
                :init-fn init-fn
                :user user
                :password password})))
