package com.example.td6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        val text_edit = findViewById<EditText>(R.id.text_edit)


        val Button = findViewById<Button>(R.id.Button)

        val githubService = Retrofit.Builder()
            .baseUrl(GithubService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
        Button.setOnClickListener {
                githubService.searchRepos(text_edit.text.toString()).enqueue(object:Callback<Repos> {
            override fun onResponse(call: Call<Repos>, response: Response<Repos>) {

                afficherRepos(response.body())
                response.body()?.let { searchRepos(it) }

            }

                    override fun onFailure(call: Call<Repos>, t: Throwable) {
                        TODO("Not yet implemented")
                    }


                })


        }


    }

    fun afficherRepos(repos: Repos?) {
        Toast.makeText(this, "nombre de dépots : " , Toast.LENGTH_SHORT).show()

        /* if (repos != null) {
             Toast.makeText(this, "nombre de dépots : " + repos.size, Toast.LENGTH_SHORT).show()
         }*/
    }



    fun searchRepos(repos: Repos) {

        val contacts : MutableList<Repo> = ArrayList<Repo>()
        val rvContacts : RecyclerView = findViewById(R.id.rvContacts)

        //Toast.makeText(this, "nombre de dépots : " + repos.size, Toast.LENGTH_SHORT).show()
        for(repo in repos.items!!){
            if (repo != null) {

                    contacts.add(repo)

            }
        }
        val adapter : ContactsAdapter = ContactsAdapter(contacts)
        rvContacts.adapter = adapter;
        rvContacts.layoutManager = LinearLayoutManager(this)




}
}



