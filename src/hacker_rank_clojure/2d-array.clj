(ns hacker-rank-clojure.2d-array
  (:gen-class))

(use '[clojure.string :only (split triml)])

(declare max-hourglass
         position-sum
         valid-hourglass-location
         get-hourglass-positions
         )

(defn max-hourglass
  "given an array, get the max hourglass value"
  [arr]
  (def all-positions (get-hourglass-positions arr))
  (def all-sums (map
                  #(position-sum (get % 0) (get % 1) arr) all-positions
                  ))
  (apply max all-sums)
  )

(defn position-sum
  "Given an hourglass position, get the sum"
  [i j arr]
  (let [positions [[i j] [i (+ j 1)] [i (+ j 2)]
                   [(+ 1 i) (+ 1 j)]
                   [(+ 2 i) j] [(+ 2 i) (+ 1 j)] [(+ 2 i) (+ 2 j)]
                   ]]
    (def hourglass-values
      (map #(get (get arr (get % 0)) (get % 1)) positions))
    (reduce + hourglass-values)
    )
  )

(defn get-hourglass-positions
  "return all valid hourglass positions"
  [arr]
  (for [i (range 0 (count arr))
        j (range 0 (count (get arr 0)))
        :let [n [i j]]
        :when (valid-hourglass-location arr i j)]
    n))

(defn valid-hourglass-location
  "check if a location in an array is a valid hourglass position"
  [arr i j]
  (let [non-zero-size (> (count arr) 0)
        valid-i (> (count arr) (+ i 2))
        valid-j (> (count (get arr 0)) (+ j 2))
        ]
    (and non-zero-size valid-i valid-j))
  )


(
  let [
       arr (for [arr_temp (range 6)] (into [](map #(Integer/parseInt %) (split (read-line) #"\s+") )) )
       ]
  (def arr-vector (into [] arr) )
  (print (max-hourglass arr-vector))
  )
