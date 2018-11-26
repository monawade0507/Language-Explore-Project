class ImageEditor {
	public fun start() {
		print("Enter the name of the image you would like to edit: ")
		
		val name = readLine()
		val path = "C:\\Users\\Bethel Tessema\\Documents\\Principles of Programming Languages\\Language-Explore-Project\\src\\bethel.jpg"
		
		var myImage: MyImage = MyImage()
		myImage.processImage(path)
		
		do {
			printMenu()
			var userInput = readLine()
			var choice: Int? = userInput!!.toIntOrNull()
			
			when(choice) {
				1-> myImage.grayscale()
				2-> myImage.blur()
				3-> myImage.rotate()
				4-> println("Goodbye!")
				else-> print("That is not a valid choice, please try again.")
			}
			
		} while (userInput != "4")
	}
	
	private fun printMenu() {
		println("Please choose one of the options below.")
		println("(1) Convert image to grayscale")
		println("(2) Blur image")
		println("(3) Rotate image")
		println("(4) Quit")
	}
	
}

fun main(args : Array<String>) {
    println("Hello, World!")
    var myImageEditor: ImageEditor = ImageEditor()
    myImageEditor.start()
	print("done")
     
}