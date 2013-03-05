-module(yet_again).
-compile(export_all).

another_factorial(0) -> 1;
another_factorial(N) -> N * another_factorial(N-1).
bad_fib(0) -> 1;
bad_fib(1) -> 1;
bad_fib(N) -> bad_fib(N-1) + bad_fib(N-2).


fib_p(0)->0;
fib_p(1)->1;
fib_p(N)->fib_p(N-1)+fib_p(N-2).
%% with guards
fib_g(N) when N == 0 ->0;
fib_g(N) when N == 1->1;
fib_g(N) when N >= 2 -> fib_g(N-1)+fib_g(N-2).
%% tail recursion
tail_fib_h(End,N,LastFib,SecondLastFib) ->
  case N of
    End -> LastFib + SecondLastFib;
    0 -> tail_fib_h(End, 1, 0, 0) ;
    1 -> tail_fib_h(End, 2, 1, 0) ;
    _ -> tail_fib_h(End,N+1,SecondLastFib+LastFib,LastFib)
  end.
tail_fib(N)->
     tail_fib_h(N,0,0,0).
