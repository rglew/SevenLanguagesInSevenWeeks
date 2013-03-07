-module(day1).
-compile(export_all).
%% using -import is bad form %%
%% shouldn't normally export all either %%


% wordcount/1
wordcount(Input) ->
    wordcount(Input, 0).

% empty match count
wordcount([], Count) ->
    Count;
% End of the input. Count the last word, if we didn't already
wordcount([C1], Count) when C1 =/= $\  ->
    Count+1;
% End of a word. Count it.
wordcount([C1, C2|Rest], Count) when C1 =/= $\ , C2 =:= $\  ->
    wordcount([C2|Rest], Count + 1);
% Not the end of a word. Don't count it. (Seems erlang needs all its cases covered - doesn't do "no" like prolog, does "error")
wordcount([_|Rest], Count) ->
    wordcount(Rest, Count).
	
	
% Praise to the baby jesus that we did Prolog before this or else it would make no sense at all!

%convenience case..
count2ten() ->
	count2ten(0).
% done when we hit 10	
count2ten(I) when I =:= 10 -> 
	I;
% not done before 10
count2ten(I) when I < 10 -> 
	io:fwrite(I,[]);
	count2ten(I+1).


log({Err, Message}) ->
	string:concat(Err, Message);
log(Success) ->
	Success.
