trait Censor {
	def censor(text:String):String = {
		var censoredText = text
		val replacements = Map("Fuck" -> "Darn", "Bastard" -> "Person of spurious birth")
		for ((curseWord, cleanWord) <- replacements) 
			censoredText = censoredText.replace(curseWord, cleanWord)
		return censoredText
	}
}

class Reviewer extends Censor

println(new Reviewer().censor("one Fuck three four Bastard Fuck"))
println("")

