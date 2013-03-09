-module(my_supervisor_example).
-behaviour(supervisor).
-export([loop/1]).
-export([start/1]).
-export([init/1]).

 loop(Count) ->
 	io:fwrite("Counting down...currently at ~p.~n", [Count]),
	timer:sleep(1000),
	case Count of
		0 -> erlang:raise(exit, "Boom!", []);
		_ -> loop(Count - 1)
	end.
	
start(Count) ->
	io:fwrite("Starting...~n"),
 	Pid=spawn_link(my_supervisor_example, loop, [Count]),
	{ok, Pid}.

init([Count]) ->
	{ok, {{one_for_one, 1,60},
		[{my_supervisor_example, {my_supervisor_example, start, [Count]},
			permanent, brutal_kill, worker, [my_supervisor_example]}]}}.