minlist([A],A).
minlist([A|LIST],MIN):- minlist(LIST,MIN0),(A=<MIN0, MIN=A ; A>MIN0, MIN=MIN0).

%-- Usage ?- minlist([2,4,6,8,1],W).
