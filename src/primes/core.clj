(ns primes.core
  (:gen-class))

(defn is_prime
  "returns true if number is prime"
  [number]
  (def root (int (Math/sqrt number)))
  (loop [iteration 2]
    (if (= iteration root)
      true
      (if (= (rem number iteration) 0)
        false
        (recur (inc iteration))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if (is_prime 13)
    (println "13 is prime!")
    (println "13 is not prime!")))





