class Generator (var passLength: Int){
		
	var counter = 0
	var repeatingLetter = 0
	var repeatingNumber = 0
	var capitalized = false
	var letters = "abcdefghijklmnopqrstuvwxyz"
	var numbers = "0123456789"
	var symbols = "#@[]!+$^&()>/"
	var randomized: List<Char> = emptyList()
	
	fun pickAValue():Char {	
		var randomLetterNumberOrSymbol= listOf<Char>(letters[(1..(letters.length-1)).random()], numbers[(1..(numbers.length-1)).random()], symbols[(1..(symbols.length-1)).random()])
		var pickFromRandomLetterNumberOrSymbol = randomLetterNumberOrSymbol[(0..2).random()]
		return pickFromRandomLetterNumberOrSymbol
		}
		
	fun randomPick():String {	
			while (counter < passLength){
				var randomValue = pickAValue()				
				if (randomValue.toString().toIntOrNull() == null){		// is letter
					if (capitalized == false){
						var randomValueToString:String = randomValue.toString().uppercase()
						randomValue = randomValueToString.toInt().toChar()
						print(randomValue)
						randomized = randomized.plus(randomValue)
						capitalized = true
					}
					if (repeatingLetter < 1){
					randomized = randomized.plus(randomValue)
					++counter
					++ repeatingLetter
					}
					else {
						repeatingLetter = 0	
					}
				} else {												// is number
					if (repeatingNumber < 1){
						randomized = randomized.plus(randomValue)
						++counter
						++ repeatingNumber 
					} else {
						repeatingNumber = 0
						}
					}	
				}	
		return randomized.joinToString(separator = "")
		}
	}

fun main() {

	print("Enter Password length: ")
	var jumbledWordLength = readLine()!!.toInt()
	var genValue = Generator(jumbledWordLength)
	println("\nYour generated password is ${genValue.randomPick()}")
}
