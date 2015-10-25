(ns primes.core-test
  (:require [clojure.test :refer :all]
            [primes.core :refer :all]))

(def prime_nums [2 3 5 7 11 13 17 19 23 27])
(deftest a-test
  (testing "Tests first 10 prime numbers for prime-ness."
    (loop [i 0]
      (if (< i (- (count prime_nums) 1))
        (do (is (is-prime (get prime_nums i)))
             (recur (inc i)))
        (println "all good")))))
