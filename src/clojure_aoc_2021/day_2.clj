(ns clojure-aoc-2021.day-2
  (:require
   [clojure-aoc-2021.util :as util]
   [clojure.string :as str]))

(def directions
  {:forward [1 0]
   :down [0 1]
   :up [0 -1]})

(defn vec-scale
  [v s]
  [(* (nth v 0) s)
   (* (nth v 1) s)])

(defn vec-add
  [v1 v2]
  [(+ (nth v1 0) (nth v2 0))
   (+ (nth v1 1) (nth v2 1))])

(defn part-1
  []
  (let [input (->> (util/load-input 2)
                   str/split-lines
                   (map (partial re-find #"(\S+) (\d+)"))
                   (map rest)
                   (map #(vec-scale (directions (keyword (first %)))
                                    (Long/parseLong (second %)))))
        position (reduce vec-add [0 0] input)]
    (reduce * position)))

(def aim-direction
  {:down 1
   :up -1})

(defn part-2
  []
  (let [input (->> (util/load-input 2)
                   str/split-lines
                   (map (partial re-find #"(\S+) (\d+)"))
                   (map rest)
                   (map #(-> [(keyword (first %)) (Long/parseLong (second %))])))
        [_ position] (reduce (fn [[aim pos] [dir amount]]
                               (let [aim (if-not (#{:forward} dir)
                                           (+ aim (* amount (aim-direction dir)))
                                           aim)]
                                 [aim
                                  (if (#{:forward} dir)
                                    [(+ (first pos) amount)
                                     (+ (second pos) (* amount aim))]
                                    pos)]))
                             [0 [0 0]]
                             input)]
    (reduce * position)))
