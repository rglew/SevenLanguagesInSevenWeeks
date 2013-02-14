guesser := Object clone
guesser guess := method(
	secretNumber := Random value(101) round
	//"SecretNumber is #{secretNumber}" interpolate println
	i := 10
	guess := -1
	"Guess a number between 1 & 100" println
	while(i > 0,
		"You have #{i} tries remaining" interpolate println
		guess = ReadLine readLine asNumber
	if((guess == secretNumber), "Correct!" println ; return,if(guess < secretNumber,"WRONG!!!! - Too Low" println,"WRONG!!!! - Too High" println))
	i = i - 1
	)
	"You have managed to defy common sense and not guess the number, you must be proud" println
)

guesser guess

	