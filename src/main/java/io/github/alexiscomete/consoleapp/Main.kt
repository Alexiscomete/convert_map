package io.github.alexiscomete.consoleapp

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

// ==== Change the number of pixels in a image ====

// size of the new image
const val WIDTH = 528
const val HEIGHT = 272
// 2 colors of the image, set with condition
const val COLOR_1 = 0x4a7899
const val COLOR_2 = 0x754b30
// multiplication factor of size of the image : draw a square around each pixel
const val FACTOR = 10

class UsedToLoad

fun main(args: Array<String>) {
    val imageOut = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    val imageIn = ImageIO.read(
        UsedToLoad::class
            .java
            .classLoader
            .getResourceAsStream("base.png")
    )
    val inWidth = imageIn.width
    val inHeight = imageIn.height
    for (x in 0 until WIDTH) {
        for (y in 0 until HEIGHT) {
            val xIn = x * inWidth / WIDTH
            val yIn = y * inHeight / HEIGHT
            val pixel = imageIn.getRGB(xIn, yIn)
            val color = Color(pixel)
            val isDirt = color.blue <= (color.red.toFloat() + color.green.toFloat()).toInt() / 1.5
            if (isDirt) {
                imageOut.setRGB(x, y, COLOR_2)
            } else {
                imageOut.setRGB(x, y, COLOR_1)
            }
        }
    }
    ImageIO.write(imageOut, "png", File("out.png"))
}

