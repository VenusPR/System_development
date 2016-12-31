(defproject org.danielsz/system "0.3.2-SNAPSHOT"
  :description "Reloaded components à la carte"
  :url "https://github.com/danielsz/system"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [prismatic/schema "1.1.3"]
                 [org.danielsz/lang-utils "0.1.0-SNAPSHOT"]
                 [org.clojure/tools.namespace "0.3.0-alpha3"]
                 [io.aviso/pretty "0.1.26"]
                 [com.stuartsierra/component "0.3.1"]]
  :profiles {:test {:dependencies [[org.clojure/clojurescript "1.8.34"]
                                   [org.clojure/tools.nrepl "0.2.11"]
                                   [cider/cider-nrepl "0.10.1"]
                                   [ring "1.4.0"]
                                   [im.chit/hara.io.watch "2.1.7"]
                                   [im.chit/hara.io.scheduler "2.3.6"]
                                   [im.chit/adi "0.3.2"]
                                   [com.datomic/datomic-free "0.9.4815.12"]
                                   [com.novemberain/monger "3.0.2"]
                                   [org.clojure/java.jdbc "0.3.5"]
                                   [com.h2database/h2 "1.4.181"]
                                   [org.postgresql/postgresql "9.4-1201-jdbc41"]
                                   [com.novemberain/langohr "2.11.0"]
                                   [clojurewerkz/neocons "3.0.0"]
                                   [clojurewerkz/quartzite "2.0.0"]
                                   [com.taoensso/sente "1.8.1"]
                                   [org.danielsz/etsy "0.1.2"]
                                   [compojure "1.4.0"]
                                   [http-kit "2.1.19"]
                                   [org.immutant/web "2.1.2"]
                                   [hikari-cp "1.6.1"]
                                   [com.taoensso/carmine "2.12.2"]
                                   [org.elasticsearch/elasticsearch "1.6.0"
                                    :exclusions [org.antlr/antlr-runtime
                                                 org.apache.lucene/lucene-analyzers-common
                                                 org.apache.lucene/lucene-grouping
                                                 org.apache.lucene/lucene-highlighter
                                                 org.apache.lucene/lucene-join
                                                 org.apache.lucene/lucene-memory
                                                 org.apache.lucene/lucene-misc
                                                 org.apache.lucene/lucene-queries
                                                 org.apache.lucene/lucene-queryparser
                                                 org.apache.lucene/lucene-sandbox
                                                 org.apache.lucene/lucene-spatial
                                                 org.apache.lucene/lucene-suggest
                                                 org.ow2.asm/asm
                                                 org.ow2.asm/asm-commons]]
                                   [aleph "0.4.0-alpha9"]]
                   :plugins [[lein-cljsbuild "1.1.3"]
                             [lein-doo "0.1.6"]]
                   :doo {:build "test"}
                   :cljsbuild {:builds [{:id "test"
                                         :source-paths ["src" "test"]
                                         :compiler {:output-to "resources/public/js/testable.js"
                                                    :main system.cljs-runner
                                                    :optimizations :none}}]}}}
  :scm {:name "git"
        :url "https://github.com/danielsz/system"}
  :test-selectors {:default (complement :dependency)
                   :dependency :dependency})

