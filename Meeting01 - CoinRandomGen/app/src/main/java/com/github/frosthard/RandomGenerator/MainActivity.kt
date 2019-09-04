package com.github.frosthard.RandomGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text)
        rollButton = findViewById(R.id.flip_button)
        rollButton.setOnClickListener {
            flipCoin()
            Toast.makeText(this, "Coin flipped!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun flipCoin() {
        val randomBool = Random().nextBoolean()
        if (randomBool.equals(true)) {
            resultText.text = "Heads"
        } else {
            resultText.text = "Tails"
        }
    }
}
