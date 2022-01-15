package com.example.catalogue_cinema;


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoActivity : AppCompatActivity() {
        var app: cataloguecinema? = null
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                app = (applicationContext as cataloguecinema)
        setContentView(R.layout.activity_info)


             val service = Retrofit.Builder()
                        .baseUrl(service.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(service::class.java)



                service.searchgenre(app!!.langue).enqueue(object: Callback<genres> {
                        override fun onResponse(call: Call<genres>, response: Response<genres>) {

                                //     afficherfilms(response.body())

                                response.body()?.let { infofilm(it) }

                        }

                        override fun onFailure(call: Call<genres>, t: Throwable) {
                                TODO("Not yet implemented")
                        }


                })
        }


        fun infofilm(list:genres) {
        val film = intent.getSerializableExtra("Extra") as? film
        if (film != null) {
        val  imageImageView: ImageView = findViewById(R.id.image);
        val name = findViewById<TextView>(R.id.title)
        val genre = findViewById<TextView>(R.id.genre)
        val release = findViewById<TextView>(R.id.release)
        val description = findViewById<TextView>(R.id.Description)

        description.setText(film.overview.toString())
        release.setText(film.release_date.toString())
        var str: String? = ""
                for (item in film.genre_ids) {
                        for (g in list.genres!!) {

                                if (g.id.equals(item.toString()))
                                {
                                      str+=g.name+" "
                                }

                        }
                }
        genre.setText(str)

        name.setText(film.title.toString())
        val path2: String? = "https://image.tmdb.org/t/p/w500"+film.poster_path;

        Glide.with(imageImageView).load(path2).into(imageImageView)
        }
        }
        }