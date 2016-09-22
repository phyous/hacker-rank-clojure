(ns hacker-rank-clojure.reduced-string-test
  (:require [clojure.test :refer :all] 
            [hacker-rank-clojure.reduced-string :refer :all]))



(deftest drop-two-test-mid
         (testing "can drop in the middle of vector"
                  (is (= [3 4] (drop-two [1 2 3 4] 1)))))

(deftest drop-two-test-begin
  (testing "can drop beginning element of vector"
    (is (= [2 3 4] (drop-two [1 2 3 4] 0)))))

(deftest drop-two-test-end
  (testing "can drop at the end of vector"
    (is (= [1 2 3] (drop-two [1 2 3 4] 3)))))

(deftest drop-two-test-oob
  (testing "dropping out of bounds returns original vecotr"
    (is (= [1 2 3 4] (drop-two [1 2 3 4] 100)))))

(deftest drop-two-test-end
  (testing "can drop at the end of vector"
    (is (= [1 2] (drop-two [1 2 3 4] 3)))))

(deftest reduce-single-duplicate-test
  (testing "return string with one dupes minus one duplicate"
    (is (= (reduce-single-duplicate ['a' 'b' 'b']) ['a']))))

(deftest reduce-single-duplicate-test2
  (testing "return string with one dupes minus one duplicate"
    (is (= (reduce-single-duplicate ['a' 'a' 'b']) ['b']))))

(deftest remove-duplicates-vector-test
  (testing "return string with one dupes minus one duplicate"
    (is (= (remove-duplicates-vector ['a' 'a' 'b' 'b']) []))))

(deftest remove-dupes-test
  (testing "given string is removed of repeating duplicates"
    (is (= (remove-dupes "aabbccc") "c"))))

