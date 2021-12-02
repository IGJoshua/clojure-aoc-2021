(ns clojure-aoc-2021.util
  (:require
   [clojure.java.io :as io]))

(defn load-input
  [day]
  (slurp (io/resource (str "day-" day ".txt"))))
