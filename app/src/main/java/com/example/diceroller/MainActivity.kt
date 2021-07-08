package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val res = dice.roll()

        // Display the result
        val resultTextView : TextView = findViewById(R.id.textView)
        resultTextView.text = res.toString()
    }

}

class Dice(private val numSides : Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}