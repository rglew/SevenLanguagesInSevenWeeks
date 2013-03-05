-module(day1).
-compile(export_all).

% wordcount/1
wordcount(Input) ->
    wordcount(Input, 0).

% wordcount/2
wordcount([], Count) ->
    Count;
% End of the input. Count the last word, if we didn't already
wordcount([C1], Count) when C1 =/= $\  ->
    Count+1;
% End of a word. Count it.
wordcount([C1, C2|Rest], Count) when C1 =/= $\ , C2 =:= $\  ->
    wordcount([C2|Rest], Count + 1);
% Not the end of a word. Don't count it.
wordcount([_|Rest], Count) ->
    wordcount(Rest, Count).