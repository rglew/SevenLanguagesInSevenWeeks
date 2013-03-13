(defn big
           [st n]
           (> (count st) n))
; (big "Check out the size of my string" 10)
; will return false..

(defn collType
            [col]
             ({(class '(1)) :list, (class '()) :list, (class []) :vector, (class {}) :map} (class col)))
			 
;Wrote the above then found the below which is a lot cleaner
(defn collTypeBetter
			[col]
              (cond (list? col) :list
                    (map? col) :map
                    (vector? col) :vector))