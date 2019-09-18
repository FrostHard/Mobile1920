package com.github.frosthard.findingstar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.frosthard.findingstar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var selectedView: View
    var selectedID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val blocks: List<Int> = listOf(
            binding.textBlock1.id,
            binding.textBlock2.id,
            binding.textBlock3.id,
            binding.textBlock4.id,
            binding.textBlock5.id,
            binding.textBlock6.id,
            binding.textBlock7.id,
            binding.textBlock8.id,
            binding.textBlock9.id
        )
        selectedID = blocks[Random.nextInt(0, 9)]
        setListeners()
    }

    private fun SetWinningCondition(view: View) {
        if(view.id == selectedID) {
            setBlockBackground(view, android.R.drawable.btn_star_big_on)
            selectedView = view
            Toast.makeText(this, "You have found the shining star! Touch the star to restart.", Toast.LENGTH_LONG).show()
            selectedView.setOnClickListener {
                resetAll()
            }
        } else setBlockBackground(view, android.R.drawable.btn_star_big_off)
    }

    private fun setBlockBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun resetAll() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val blocks: List<Int> = listOf(
            binding.textBlock1.id,
            binding.textBlock2.id,
            binding.textBlock3.id,
            binding.textBlock4.id,
            binding.textBlock5.id,
            binding.textBlock6.id,
            binding.textBlock7.id,
            binding.textBlock8.id,
            binding.textBlock9.id)
        selectedID = blocks[Random.nextInt(0, 9)]

        val textBlock1 = findViewById<TextView>(R.id.text_block1)
        val textBlock2 = findViewById<TextView>(R.id.text_block2)
        val textBlock3 = findViewById<TextView>(R.id.text_block3)
        val textBlock4 = findViewById<TextView>(R.id.text_block4)
        val textBlock5 = findViewById<TextView>(R.id.text_block5)
        val textBlock6 = findViewById<TextView>(R.id.text_block6)
        val textBlock7 = findViewById<TextView>(R.id.text_block7)
        val textBlock8 = findViewById<TextView>(R.id.text_block8)
        val textBlock9 = findViewById<TextView>(R.id.text_block9)

        val clickableViews: List<View> =
            listOf(textBlock1, textBlock2, textBlock3, textBlock4, textBlock5, textBlock6, textBlock7, textBlock8, textBlock9)

        for (item in clickableViews) {
            item.setOnClickListener {
                SetWinningCondition(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val textBlock1 = findViewById<TextView>(R.id.text_block1)
        val textBlock2 = findViewById<TextView>(R.id.text_block2)
        val textBlock3 = findViewById<TextView>(R.id.text_block3)
        val textBlock4 = findViewById<TextView>(R.id.text_block4)
        val textBlock5 = findViewById<TextView>(R.id.text_block5)
        val textBlock6 = findViewById<TextView>(R.id.text_block6)
        val textBlock7 = findViewById<TextView>(R.id.text_block7)
        val textBlock8 = findViewById<TextView>(R.id.text_block8)
        val textBlock9 = findViewById<TextView>(R.id.text_block9)

        val clickableViews: List<View> =
            listOf(textBlock1, textBlock2, textBlock3, textBlock4, textBlock5, textBlock6, textBlock7, textBlock8, textBlock9)

        for (item in clickableViews) {
            item.setOnClickListener {
                SetWinningCondition(it)
            }
        }
    }
}
