(ns hacker-rank-clojure.camelcase-test
  (:require [clojure.test :refer :all]
            [hacker-rank-clojure.camelcase :refer :all]))

(deftest count-words-test
  (testing "can coutn # of words in camelcase"
    (is (= (count-words "hiThere") 2))))
