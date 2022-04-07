package ca.damocles.blackjack.io

import ca.damocles.bicycle.Card
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value
import java.awt.Graphics
import java.awt.Image
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class GraphicsIO: IOForm {

    var showing: Card = Card(Suit.SPADE, Value.ACE)
    var message = "FlipThrough"
    val frame: JFrame = object : JFrame("FlipThrough"){
        override fun paint(g: Graphics?) {
            super.paint(g)
            g?.drawString(message, this.size.width/2, 100)
            g?.drawImage(getImageFromCard(), this.size.width/2, this.size.height/2, null)
        }
    }

    init{

        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(800, 600)
        frame.isVisible = true

    }

    fun getImageFromCard(): Image{
        println("${showing.suit.formattedName}/${showing.value.simpleRepresentation}.png")
        return ImageIO.read(this.javaClass.getResource("/${showing.suit.formattedName}/${showing.value.simpleRepresentation}.png"));
    }

    override fun prompt(message: Any) {
        if(message is Card){
            showing = message
            frame.repaint()
        }
        if(message is String){
            this.message = message
            frame.repaint()
        }
    }

    override fun input(): String {
        return readLine().toString()
    }


}