package com.example.catalogue_cinema


import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class adapteur(contacts : List<film>): RecyclerView.Adapter<adapteur.ViewHolder>()
{
    var mContacts: List<film> = contacts
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val  NameTextview: TextView =view.findViewById(R.id.title)
        //  val  descriptionTextView: TextView = view.findViewById(R.id.Description);

        //   val  idTextview: TextView = view.findViewById(R.id.id)
        val  imageImageView: ImageView = view.findViewById(R.id.image);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var context : Context = parent.getContext()
        var inflater : LayoutInflater = LayoutInflater.from(context)

        var contactView: View =inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact: film = mContacts.get(position)

        var firstNameTextView = holder.NameTextview
        //  var descriptionTextView = holder.descriptionTextView
        //  descriptionTextView.setText(contact.overview)
        var imageView = holder.imageImageView
        firstNameTextView.setText(contact.title)

        //  var idTextView = holder.idTextview
        //idTextView.setText(contact.id.toString())
        // val path: String? = "https://api.themoviedb.org/3/movie/"+contact.id.toString()+"/images?api_key=c1a1588b613cef60cc1c1934f75a5e24&language=en-US"
        val path2: String? = "https://image.tmdb.org/t/p/w500"+contact.poster_path;

        Glide.with(holder.imageImageView).load(path2).fitCenter().into(holder.imageImageView)
        imageView.setOnClickListener {
            Toast.makeText(imageView.context, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()
            val intent = Intent(imageView.context, InfoActivity::class.java)
            intent.putExtra("Extra",mContacts.get(position))
            imageView.context.startActivity(intent)
        }


    }



    override fun getItemCount(): Int {
        return mContacts.size;
    }


}

