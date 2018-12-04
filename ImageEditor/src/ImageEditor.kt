import java.util.*

class ImageEditor {
	public fun start() {
		print("Enter the name of the image you would like to edit: ")
		
		val name = readLine()
		val path = "C:\\Users\\Bethel Tessema\\Documents\\Principles of Programming Languages\\Language-Explore-Project\\ImageEditor\\src\\" + name
		
		var myImage: MyImage = MyImage()
		myImage.processImage(path)
		
		do {
			printMenu()
			var userInput = readLine()
			var choice: Int? = userInput!!.toIntOrNull()
			
			when(choice) {
				1-> myImage.grayscale()
				2-> myImage.contrast()
				3-> myImage.negate_blue()
				4-> myImage.flatten_blue()
				5-> myImage.save()
				6-> start()
				7-> println("Goodbye!")
				else-> println("That is not a valid choice, please try again.")
			}
			
		} while (userInput != "7")
	}
	
	private fun printMenu() {
		println("Please choose one of the options below.")
		println("(1) Convert image to grayscale")
		println("(2) Contrast image")
		println("(3) Negate blue")
		println("(4) Flatten blue")
		println("(5) Save Changes")
		println("(6) Select a different image")
		println("(7) Quit")
	}
	
}

fun main(args : Array<String>) {
    println("Hello, World!")
    var myImageEditor: ImageEditor = ImageEditor()
    myImageEditor.start()
     
}