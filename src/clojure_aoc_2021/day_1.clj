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

(defn part-2
  []
  (let [input (->> (util/load-input 1)
                   str/split-lines
                   (map #(Long/parseLong %)))]
    (->> input
         (partition 3 1)
         (map #(reduce + %))
         (partition 2 1)
         (filter (partial apply <))
         count)))
