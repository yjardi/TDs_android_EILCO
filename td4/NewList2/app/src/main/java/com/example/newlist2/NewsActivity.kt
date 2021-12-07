package com.example.newlist2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.String.valueOf

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setTitle(getLocalClassName())
        val intent1 = getIntent();

        val text_edit =  findViewById<TextView>(R.id.text)
        val rollButton = findViewById<Button>(R.id.buttonDetail)

        val rollButton_two = findViewById<Button>(R.id.buttonLogout)

        val rollButton_three = findViewById<Button>(R.id.buttonNews)

        if (intent1.hasExtra("login")) {
            val login = intent1.getStringExtra("login")
            text_edit.text=(login)
            val toast= Toast.makeText(applicationContext, login, Toast.LENGTH_SHORT)
            toast.show()


        }



        rollButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
        rollButton_two.setOnClickListener {
            val intent_two = Intent(this, LoginActivity::class.java)
            startActivity(intent_two)
        }
        rollButton_three.setOnClickListener {
            val url = "https://news.google.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }


    }


}