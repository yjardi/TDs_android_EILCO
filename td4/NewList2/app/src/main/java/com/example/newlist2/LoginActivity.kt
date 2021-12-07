package com.example.newlist2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.String.valueOf


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle(getLocalClassName())


        val text_edit = findViewById<EditText>(R.id.text_edit)



        val rollButton = findViewById<Button>(R.id.button_login)

        rollButton.setOnClickListener {
            val log = (applicationContext as NewsListApplication)
            log.login =text_edit.getText().toString()
            val intent = Intent(this, NewsActivity::class.java)
             intent.putExtra("login", text_edit.getText().toString() )
            startActivity(intent)

            //val intent = Intent(this, NewsActivity::class.java)
           // startActivity(intent)

            finish()
        }
    }
}