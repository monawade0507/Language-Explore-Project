import java.io.File
//import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class MyImage {
	private var width: Int = 0
	private var height: Int = 0
	
	public fun processImage(name: String): Int {
		try {
			val file = File(name)
			val buff = ImageIO.read(file)
			width = buff.getWidth()
			height = buff.getHeight()
		} catch (e: javax.imageio.IIOException) {
			println("Error - that image could not be opened.")
			println("Please make sure your image is in the working directory, or try another image.\n")
			return -1
		}
		
		
		
		return 1
	}
	
	public fun grayscale() {}
	public fun blur() {}
	public fun rotate() {}
	
	public fun getWidth(): Int { return width }
	public fun getHeight(): Int { return height }

}