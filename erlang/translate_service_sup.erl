-module(translate_service_sup).
-behaviour(supervisor).
-export([loop/0, translate/1]).
-export([start/0]).
-export([init/1]).
-export([start_service/0]).

loop() ->
  receive
    {From, "casa"} ->
      From ! "house",
      loop();
    {From, "blanca"} ->
      From ! "white",
      loop();
    {From,M} ->
      From ! "How rude!",
      exit({M, not_understood, received_at, erlang:time()})
  end.

translate(Word) ->
  translator ! {self(), Word},
  receive
    Translation -> Translation
  end.

start() ->
    io:fwrite("Starting...~n"),
    register(translator, spawn_link(translate_service_sup, loop, [])),
    {ok, whereis(translator)}.

init(_) ->
    {ok, {{one_for_one, 10, 60},
          [{translate_service_sup, {translate_service_sup, start, []},
            permanent, brutal_kill, worker, [translate_service_sup]}]}}.

start_service() ->
    io:fwrite("start_service~n"),
    supervisor:start_link(translate_service_sup, []).
	
%% Usage:
%% c(translate_service_sup).
%% translate_service_sup:start_service().
%% translate_service_sup:translate("casa").
%% translate_service_sup:translate("puta").