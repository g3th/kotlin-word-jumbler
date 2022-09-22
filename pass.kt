class Generator (var passLength: Int){
		
	var counter = 0
	var repeatingLetter = false
	var letters = "abcdefghijklmnopqrstuvwxyz"
	var numbers = "0123456789"
	var symbols = "#@[]!+$^&()>/"
	var randomized: List<Char> = emptyList()
	
	fun randomPick():String {

			while (counter < passLength){

				var randomLetterNumberOrSymbol= listOf<Char>(letters[(1..(letters.length-1)).random()], numbers[(1..(numbers.length-1)).random()], symbols[(1..(symbols.length-1)).random()])

				var pickFromRandomLetterNumberOrSymbol = listOf<Char>(randomLetterNumberOrSymbol[(0..2).random()])
				randomized = randomized.plus(pickFromRandomLetterNumberOrSymbol)
				++counter			
			}
		return randomized.joinToString(separator = "")
	}
}

fun main() {

	println("Enter Password length: ")
	var jumbledWordLength = readLine()!!.toInt()
	var genValue = Generator(jumbledWordLength)
	print(genValue.randomPick())
}
