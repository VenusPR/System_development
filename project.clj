(defproject org.danielsz/system "0.1.0-SNAPSHOT"
  :description "Reloaded components à la carte"
  :url "https://github.com/danielsz/system"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.0"]
                 [org.clojure/tools.nrepl "0.2.3"]
                 [reloaded.repl "0.1.0"]
                 [com.stuartsierra/component "0.2.1"]
                 [com.datomic/datomic-free "0.9.4815.12"]
                 [com.novemberain/monger "2.0.0"]
                 [com.novemberain/langohr "2.11.0"]
                 [com.taoensso/sente "0.15.1"]
                 [http-kit "2.1.18"]]
  :scm {:name "git"
        :url "https://github.com/danielsz/system"})
