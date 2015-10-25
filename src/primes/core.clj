(ns primes.core
  (:gen-class))

(defn parse-int 
  "return digits as integer from string"
  [s]
  (Integer. (re-find #"\d+" s)))

(defn is-prime
  "returns true if number is prime"
  [number]
  (def root (int (Math/sqrt number)))
  ;; if number is divisible by an number between 2 and it's sqrt,
  ;; it is not a prime
  (loop [iteration 2]
    (if (> iteration root)
      true
      (if (= (rem number iteration) 0)
        false
        (recur (inc iteration))))))

(defn -main
  "Take in number of primes, find primes, print primes."
  [& args]
  
  ;; define vector of primes
  (def primes [])

  ;; get number of desired primes from user
  ;; change into integer format
  (println "Please enter the number of primes: ")
  (def num-primes (parse-int (read-line)))

  ;; loop starting from first prime number user-specified times
  ;; if a number is prime, add it to the prime numbers vector
  (loop [number 2]
    (when (< (count primes) num-primes)
      (do (when (is-prime number)
            (do (def primes (conj primes number))
                 (println number)))
          (recur (inc number))))))






