reverse([X|Y],Z,W) :- reverse(Y,[X|Z],W).
reverse([],X,X).

%-- usage ?- reverse([1,2,a,4,5],[],W).