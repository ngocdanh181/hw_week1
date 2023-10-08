package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        rollButton.setOnClickListener {
            // Roll both dice and update their images and content descriptions
            rollDice(diceImage1)
            rollDice(diceImage2)
        }

        // Roll both dice when the app starts
        rollDice(diceImage1)
        rollDice(diceImage2)
    }

    /**
     * Roll the dice and update the screen with the result for a given ImageView.
     */
    private fun rollDice(imageView: ImageView) {
        // Create a new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        imageView.setImageResource(drawableResource)

        // Update the content description
        imageView.contentDescription = diceRoll.toString()
    }
}


//This class is used to randomly select a number.
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
