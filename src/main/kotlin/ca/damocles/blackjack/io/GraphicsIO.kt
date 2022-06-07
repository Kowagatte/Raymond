package ca.damocles.blackjack.io

import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.WindowConstants

class GraphicsIO: IOForm {

    val frame: JFrame = object : JFrame("Default Frame"){
        override fun paint(g: Graphics?) {
            super.paint(g)
        }
    }

    init{
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(800, 600)
        frame.isVisible = true
    }

    override fun print(message: Any) {
        //TODO
    }

    override fun input(): String {
        return readLine().toString()
    }


}