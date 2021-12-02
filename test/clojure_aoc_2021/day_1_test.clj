(ns clojure-aoc-2021.day-1-test
  (:require [clojure.test :as t]
            [clojure-aoc-2021.day-1 :as sut]))

(t/deftest part-1
  (t/is (= 1754 (sut/part-1))))

(t/deftest part-2
  (t/is (= 1789 (sut/part-2))))
