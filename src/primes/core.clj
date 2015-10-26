(ns primes.core
  (:gen-class))

(defn parse-int 
  "return digits as integer from string"
  [s]
  (Integer. (re-find #"\d+" s)))

(defn is-prime
  "returns true if number is prime"
  [number]
  (if (or (= number 0) (= number 1))
    false
    (do (def root (int (Math/sqrt number)))
      ;; if number is divisible by an number between 2 and it's sqrt,
      ;; it is not a prime
      (loop [iteration 2]
        (if (> iteration root)
          true
          (if (= (rem number iteration) 0)
            false
            (recur (inc iteration))))))))
  
(defn make-row
  "Create row for primes multiplication table"
  [primes spot]
  (def row (vector (get primes spot)))
  (loop [number 0]
    (when (<= (count row) (count primes))
      (do (def row (conj row (* (get row 0) (get primes number))))
          (recur (inc number))))))

  

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
            (def primes (conj primes number)))
          (recur (inc number)))))

  ;; create table data
  ;; TOP ROW: create string for top row of column names
  (def col-str (str "  " (clojure.string/join " " primes)))

  ;;(make-row primes 0)
  (def row-str (clojure.string/join " " (make-row primes 0)))

  
  ;; print table
  (println col-str)
  (loop [it 0]
    (when (< it (count primes))
      (do (make-row primes it)
          (def row-str (clojure.string/join " " row))
          (println row-str))
          (recur (inc it))))
      
  
)





