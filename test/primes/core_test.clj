(ns primes.core-test
  (:require [clojure.test :refer :all]
            [primes.core :refer :all]))

(def prime-nums [2 3 5 7 11 13 17 19 23 27])
(deftest prime-test
  (testing "Tests first 10 prime numbers for prime-ness."
    (loop [i 0]
      (when (< i (- (count prime-nums) 1))
        (do (is (is-prime (get prime-nums i)))
             (recur (inc i)))))))

;; just in case something happens where is-prime is 
;; passed a 0
(deftest zero-test
  (testing "tests that 0 is not returned as prime"
    (is (= (is-prime 0) false))))

;; includes case of 1, even though program shouldn't call it
(def not-prime-nums [1 4 6 8 9 10 12 14 15 16])
(deftest not-prime-test
  (testing "Tests first 10 non-prime numbers for non-prime-ness"
    (loop [j 0]
      (when (< j (- (count not-prime-nums) 1))
        (do (is (= (is-prime (get not-prime-nums j)) false))
            (recur (inc j)))))))

