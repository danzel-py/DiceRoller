package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Rolls dice when app starts
        rollDice()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    private fun rollDice() {
        // Create new 6 sided Dice and roll it
        val dice = Dice(6)
        val diceRes = dice.roll()

        // Find image resource
        val resImage : ImageView = findViewById(R.id.imageView)

        // Determine which dice image
        val diceImage = when(diceRes) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }

        // Update dice image
        resImage.setImageResource(diceImage)

        // Update content desc
        resImage.contentDescription = diceRes.toString()
    }

}

class Dice(private val numSides : Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}