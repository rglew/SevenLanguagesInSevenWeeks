%% Copyright
-module(day3).
-author("rglew").
-behaviour(supervisor).
-export([init/1]).
-export([start/1]).
-export([loop/1]).

loop(Count) ->
  io:fwrite("Counting down...currently at ~p.~n", [Count]),
  timer:sleep(1000),
  case Count of
    0 -> erlang:raise(exit, "Boom!", []);
    _ -> loop(Count - 1)
  end.

start(Count) ->
  io:fwrite("Starting...~n"),
  Pid=spawn_link(day3, loop, [Count]),
  {ok, Pid}.

init([Count]) ->
  {ok, {{one_for_one, 6,60},
    [{day3, {day3, start, [Count]},
      permanent, brutal_kill, worker, [day3]}]}}.
