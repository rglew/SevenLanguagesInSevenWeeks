wrote(china_mieville,perdido_street_station).
wrote(china_mieville,kraken).
wrote(china_mieville,the_scar).
wrote(china_mieville,iron_council).
wrote(jeff_vandermeer,city_of_saints_and_madmen).
wrote(jeff_vandermeer,shriek_an_afterword).
wrote(robert_zelazny,the_chronicles_of_amber).
wrote(peter_f_hamilton,great_north_road).
wrote(ian_m_banks,excession).
wrote(ian_m_banks,use_of_weapons).
wrote(ian_m_banks,the_hydrogen_sonata).
wrote(ian_m_banks,consider_phlebas).
wrote(peter_f_hamilton,the_nights_dawn_trilogy).

/*** | ?- wrote(china_mieville, What).
a */

plays(john, guitar).
plays(peter, piano).
plays(freddy, skin_flute).
plays(jimmy, guitar).
plays(jane, drums).
plays(sally, piano).
genre(john, classical).
genre(peter, jazz).
genre(freddy, rock).
genre(jimmy, rock).
genre(jane, jazz).
genre(sally, classical).

musician_genre(X, Y) :- plays(Z, X), genre(Z, Y).

/** plays(Who, guitar). */
