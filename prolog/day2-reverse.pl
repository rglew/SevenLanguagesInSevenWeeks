reverse([X|Y],Z,W) :- reverse(Y,[X|Z],W).
reverse([],X,X).