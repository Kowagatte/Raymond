package ca.damocles.trainer.flipthrough

import ca.damocles.bicycle.Card
import ca.damocles.bicycle.MultiDeck
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value
import ca.damocles.blackjack.io.IOForm
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.Graphics
import java.awt.Image
import java.lang.Thread.sleep
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.WindowConstants
import kotlin.concurrent.thread


class FlipThroughIO: IOForm{

    private var showing: Card = Card(Suit.SPADE, Value.ACE)
    var message = "FlipThrough"
    var prompting = false
    var inputBox = JTextField("1000")

    private val frame: JFrame = JFrame("FlipThrough")

    private val panel: JPanel = object : JPanel(){
        override fun paint(g: Graphics?) {
            super.paint(g)
            g?.drawString(message, this.size.width/2 - message.length*3, 100)
            val img = getImageFromCard()
            g?.drawImage(img, this.size.width/2 - img.getWidth(null)/2, this.size.height/2 - img.getHeight(null)/2, null)
        }
    }

    init{
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(800, 600)
        frame.isResizable = false


        //inputBox.setLocation(frame.size.width/2, (frame.size.height/3) * 2)
        //inputBox.setLocation(frame.size.width/2, (frame.size.height/3)*2)
        //inputBox.setLocation(0, 0)
        println("${frame.size.height}")

        panel.add(inputBox)

        frame.add(panel)
        frame.isVisible = true

    }

    fun getImageFromCard(): Image {
        //println("${showing.suit.formattedName}/${showing.value.simpleRepresentation}.png")
        return ImageIO.read(this.javaClass.getResource("/${showing.suit.formattedName}/${showing.value.simpleRepresentation}.png"));
    }

    override fun print(message: Any) {
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

fun main(){

    val io: IOForm = FlipThroughIO()

    io.print("How many decks to flip through?")
    //val numOfDecks: Int = IOAccess.io.input().toInt()
    val numOfDecks = 1

    io.print("How fast should we flip through? (in millis)")
    //val speed: Long = io.input().toLong()
    val speed = 100L

    val decks = MultiDeck(numOfDecks)

    decks.shuffle()

    val missingCard = decks.draw()

    val finalCount: Int = missingCard.value.hiloValue * -1

    //IOAccess.io.prompt("Starting to flip through")
    thread{
        var count = 0
        while(true){
            if(decks.isEmpty())
                break
            val card = decks.draw()
            count += card.value.hiloValue
            io.print(card)
            sleep(speed)
        }
        io.print("What is the count?")
        io.print("Your answer: ${io.input()} | Missing Card: $missingCard | Correct count: $finalCount")
    }
}