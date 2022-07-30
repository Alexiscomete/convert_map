import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

// ==== Change the number of pixels in a image ====

// size of the new image
const val WIDTH = 528
const val HEIGHT = 272

fun main(args: Array<String>) {
    val imageOut = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    val imageIn = ImageIO.read(
        Map::class.java.classLoader.getResourceAsStream("base.png")
    )
    val inWidth = imageIn.width
    val inHeight = imageIn.height
    for (x in 0 until WIDTH) {
        for (y in 0 until HEIGHT) {
            val xIn = x * inWidth / WIDTH
            val yIn = y * inHeight / HEIGHT
            val pixel = imageIn.getRGB(xIn, yIn)
            imageOut.setRGB(x, y, pixel)
        }
    }
    ImageIO.write(imageOut, "png", File("out.png"))
}

