package com.example.td6


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactsAdapter(contacts : List<Repo>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>()
{
    var mContacts: List<Repo> = contacts
    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val  firstNameTextview:TextView=view.findViewById(R.id.Name);
        val  lastNameTextview:TextView = view.findViewById(R.id.full_name);
        val  idTextview:TextView = view.findViewById(R.id.id);
        val  html_urlTextview:TextView = view.findViewById(R.id.html);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var context : Context = parent.getContext()
        var inflater : LayoutInflater = LayoutInflater.from(context)

        var contactView: View=inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact: Repo = mContacts.get(position);

        var firstNameTextView = holder.firstNameTextview
        firstNameTextView.setText(contact.name)
        var lastNameTextView = holder.lastNameTextview
        lastNameTextView.setText(contact.full_name)
        var idTextView = holder.idTextview
        idTextView.setText(contact.id.toString())
        var html_urlTextView = holder.html_urlTextview
        html_urlTextView.setText(contact.html_url)



    }

    override fun getItemCount(): Int {
        return mContacts.size;
    }


}
