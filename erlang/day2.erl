-module(day2).
-compile(export_all).

description(Language) ->
	LangList = [{erlang, "a functional language"}, {ruby, "an OO language"}, {scala, "a bullshit language"}, {prolog, "a declarative language"}, {c, "a procedural language"},{io, "a prototype language"},{java, "slightly less evil than PHP"},{assembler,"machine language"}],
	{_,E} = lists:keyfind(Language,1,LangList),
	E.

%How awesome is this...
%Order = [{pencil, 4, 0.25}, {pen, 1, 1.20}, {paper, 2, 0.20}].	
total(Order) = [{Item, Price * Quantity} || {Item, Quantity, Price,} <- Order].




	
	