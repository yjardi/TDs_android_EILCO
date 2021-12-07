package com.example.newlist2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val text = findViewById<TextView>(R.id.text)
        title = localClassName
        val log = (applicationContext as NewsListApplication)
        text.text = log.login
        val rollButton = findViewById<Button>(R.id.buttonDetail)

        rollButton.setOnClickListener{
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
    }
}