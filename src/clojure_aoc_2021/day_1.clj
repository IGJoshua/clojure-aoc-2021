(ns clojure-aoc-2021.day-1
  (:require
   [clojure-aoc-2021.util :as util]
   [clojure.string :as str]))

(defn part-1
  []
  (let [input (->> (util/load-input 1)
                   str/split-lines
                   (map #(Long/parseLong %)))]
    (count (filter (partial apply <) (partition 2 1 input)))))
