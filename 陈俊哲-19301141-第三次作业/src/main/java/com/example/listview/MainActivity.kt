package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            val intent = Intent(this, ArrayAdapter_button::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, SimpleAdapter_button::class.java)
            startActivity(intent)
        }
    }
}