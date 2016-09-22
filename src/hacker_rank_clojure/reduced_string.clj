;https://www.hackerrank.com/challenges/reduced-string
(ns hacker-rank-clojure.reduced-string)

(defn drop-two [vec n]
  "drops the n & n-1 element from a vector"
  (if (or (>= n (count vec)) (< n 1)) vec)
  (into [] (apply concat [(take (- n 1) vec) (drop (+ n 1) vec)]))
  )

(defn reduce-single-duplicate
  "removes a single set of similar subsequent characters"
  [input-chars]
  (loop [n 0
         chars input-chars]
    (if (= n (count chars))
      chars
      (if (= (get chars n) (get chars (- n 1)))
        (drop-two chars n)
        (recur (+ n 1) chars)
        )
      )))

(defn remove-duplicates-vector
  "removes all repeating duplicates in a vector"
  [input-chars]
  (loop [chars input-chars]
    (let [new-chars (reduce-single-duplicate chars)]
      (if (= new-chars chars)
        chars
        (recur new-chars)
        )
      )))

(defn remove-dupes
  [s]
  (def result (clojure.string/join
                ""
                (remove-duplicates-vector
                  (clojure.string/split s #""))))
  (if (= result "")
    "Empty String"
    result)
  )

(
  let [
       input-str (read-line) 
       ]
  (print (remove-dupes input-str) )
)
