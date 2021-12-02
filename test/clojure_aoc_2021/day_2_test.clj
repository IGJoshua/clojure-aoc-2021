(ns clojure-aoc-2021.day-2-test
  (:require [clojure.test :as t]
            [clojure-aoc-2021.day-2 :as sut]))

(t/deftest part-1
  (t/is (= 1815044 (sut/part-1))))

(t/deftest part-2
  (t/is (= 1739283308 (sut/part-2))))
