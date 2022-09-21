class Generator (var passLength: Int){
		
	var counter = 0	
	var letters = "abcdefghijklmnopqrstuvwxyz"
	var randomized: List<Char> = emptyList()
	
	fun jumble(){
		while (counter < passLength){
			var randomIndex = (0..(letters.length)).random()
			randomized = randomized.plus(letters[randomIndex])
			++ counter
			}
		println(randomized)	
		}
}

fun main(){
	println("Enter jumbled word length: ")
	var jumbledWordLength = readLine()!!.toInt()
	var genValue = Generator(jumbledWordLength)
	genValue.jumble()
}
