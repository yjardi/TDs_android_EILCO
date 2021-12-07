package com.example.tp5

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter(contacts : List<Contact>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>()
{
    var mContacts: List<Contact> = contacts
    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val  firstNameTextview:TextView=view.findViewById(R.id.Nom);
        val  lastNameTextview:TextView = view.findViewById(R.id.Prenom);
        val  imageImageView:ImageView = view.findViewById(R.id.image);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var context : Context = parent.getContext()
        var inflater : LayoutInflater = LayoutInflater.from(context)

        var contactView: View=inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact: Contact = mContacts.get(position);

        var firstNameTextView = holder.firstNameTextview
        firstNameTextView.setText(contact.Prenom)
        var lastNameTextView = holder.lastNameTextview
        lastNameTextView.setText(contact.Nom)
        Glide.with(holder.imageImageView).load(contact.imageUrl).into(holder.imageImageView)

    }

    override fun getItemCount(): Int {
        return mContacts.size;
    }


}

