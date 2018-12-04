import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.util.ArrayList
import java.util.*

class MyImage {
	private var width: Int = 0
	private var height: Int = 0
	
	private var image: BufferedImage = BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB)
	
	//private var pixels[][]: List<Pixel>
	private var rows = Array(1000) {Pixel()}
	private var columns = Array(1000) {Pixel()}
	private var grid = Array(1000, {Array(1000) {Pixel()}})

	public fun processImage(name: String): Int {
		try {
			val file = File(name)
			image = ImageIO.read(file)
			
			width = image.getWidth()
			height = image.getHeight()

			parsePixels()
			
		} catch (e: javax.imageio.IIOException) {
			println("Error - that image could not be opened.")
			println("Please make sure your image is in the working directory, or try another image.\n")
			return -1
		}
		
		
		
		return 1
	}
	
	private fun parsePixels() {
		for (i in 0..width-1) {
			for (j in 0..height-1) {
				var pixel: Int = image.getRGB(i,j);
				var p: Pixel = Pixel()
				//source for conversions:
				//https://stackoverflow.com/questions/22391353/get-color-of-each-pixel-of-an-image-using-bufferedimages
				var alpha: Int = (pixel.shr(24)).and(0xFF)
				var red: Int = (pixel.shr(16)).and(0xFF)
				var green: Int = (pixel.shr(8)).and(0xFF)
				var blue: Int = pixel.and(0xFF)
				
				p.alpha = alpha
				p.red = red
				p.green = green
				p.blue = blue

				grid[i][j] = p
			}
		}
	}
	
	public fun grayscale() {
		for (i in 0..width-1) {
			for (j in 0..height-1) {
				var p: Pixel = grid[i][j]
				
				var average: Int = (p.red+p.blue+p.green)/3
				
				var result: Int = (p.alpha.shl(24)).or(average.shl(16)).or(average.shl(8)).or(average)

				image.setRGB(i, j, result);
				
			}
		}
		
	}
	
	public fun contrast() {
		for (i in 0..width-1) {
			for (j in 0..height-1) {
				var p: Pixel = grid[i][j]
				if(p.red <= (255/2)) p.red = 0
				else p.red = 255
				if (p.blue <= (255/2)) p.blue = 0
				else p.blue = 255
				if (p.green <= (255/2)) p.green = 0
				else p.green = 255
				
				var result: Int = (p.alpha.shl(24)).or(p.red.shl(16)).or(p.green.shl(8)).or(p.blue)
				image.setRGB(i, j, result)
					
			}
		}
	}
	public fun negate_blue() {
		for (i in 0..width-1) {
			for (j in 0..height-1) {
				var p: Pixel = grid[i][j]
				p.blue = 255 - p.blue
				
				var result: Int = (p.alpha.shl(24)).or(p.red.shl(16)).or(p.green.shl(8)).or(p.blue)
				image.setRGB(i, j, result)
			}
		}
	}
	
	public fun flatten_blue() {
		for (i in 0..width-1) {
			for (j in 0..height-1) {
				var p: Pixel = grid[i][j]
				p.blue = 0
				
				var result: Int = (p.alpha.shl(24)).or(p.red.shl(16)).or(p.green.shl(8)).or(p.blue)
				image.setRGB(i, j, result)
			}
		}
	}
	
		public fun save() {
		print("Please provide a name for your output image: ")
		var userInput = readLine()
		try {
			val file = File("C:\\Users\\Bethel Tessema\\Documents\\Principles of Programming Languages\\Language-Explore-Project\\ImageEditor\\src\\" + userInput)
			ImageIO.write(image, "jpg", file)
		} catch(e: javax.imageio.IIOException) {
			println("Sorry, there was an error saving your image.")
		}

	}
	
	public fun getWidth(): Int { return width }
	public fun getHeight(): Int { return height }

}

//turning blue: //var result: Int = (p.alpha.shr(24)).or(average.shr(16)).or(average.shr(8)).or(average)
