package com.github.frosthard.lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG="Main Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "In Oncreate")
        val about_us = findViewById<Button>(R.id.about_us)
        about_us.setOnClickListener{
            val i = Intent(this, AboutUs::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "In Onstart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "In Onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "In Ondestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "In Onrestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "In Onresume")
    }
}
