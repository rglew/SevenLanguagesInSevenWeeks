(defmacro unless
  ([test body] `(if (not ~test) ~body))
  ([test body alt] `(if (not ~test) ~body ~alt)))