package com.example.dice_roller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String.valueOf


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.button)

        val text_edit = findViewById<EditText>(R.id.text_edit);

        rollButton.setOnClickListener {
            val value = Integer.parseInt(text_edit.text.toString())

        //Exercice 1
            //val rnds = (1..6).random() //trouver la valeur random entre 1 et 6
            //text.setText(valueOf(rnds))// afficher la valeur

        //Exercice 2
            //val rnds = (1..6).random() //trouver la valeur random entre 1 et 6
            //text.setText(valueOf(rnds))// afficher la valeur

            //val rnds_two = (1..6).random() //trouver la valeur random entre 1 et 6
            //text_two.setText(valueOf(rnds_two))// afficher la valeur

        //Exercice 3
            val rnds = (1..value).random() //trouver la valeur random entre 1 et 6
            text.setText(valueOf(rnds))// afficher la valeur

            val rnds_two = (1..value).random() //trouver la valeur random entre 1 et 6
            text_two.setText(valueOf(rnds_two))// afficher la valeur
        }
    }
}
