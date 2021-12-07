package com.example.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val contacts : MutableList<Contact> = ArrayList<Contact>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val rvContacts : RecyclerView= findViewById(R.id.rvContacts)

        contacts.add(Contact("chat","Noir","https://static.wikia.nocookie.net/miraculousladybug/images/a/af/Chat_Noir_Carr%C3%A9.webp/revision/latest?cb=20210627214552&path-prefix=fr"));
        contacts.add(Contact("lady","Bug","https://static.wikia.nocookie.net/lady-bug/images/8/85/Ladybug_Sentimonster_square.png/revision/latest?cb=20200930060841"));
        contacts.add(Contact("dog","mess","https://static.wikia.nocookie.net/lady-bug/images/e/e5/Barkk_Square.png/revision/latest/top-crop/width/360/height/360?cb=20210914092727"));
        contacts.add(Contact("Rena","Rouge","https://i.pinimg.com/564x/64/35/6b/64356b64eae1a78d5864f3e6e052edd8.jpg"));
        contacts.add(Contact("Queen","Bee","https://static.wikia.nocookie.net/lady-bug/images/a/ae/Queen_Bee_Square_1.png/revision/latest?cb=20200213035020"));
        contacts.add(Contact("cock","momo","https://static.wikia.nocookie.net/p__/images/1/13/Orikko.png/revision/latest?cb=20191015170045&path-prefix=protagonist"));
        contacts.add(Contact("tiger","ombe","https://i.imgur.com/zHQoyYz.jpg"));
        contacts.add(Contact("dragon","Jack","https://static.wikia.nocookie.net/lady-bug/images/4/45/Longg_Square.png/revision/latest?cb=20191207110824"));
        contacts.add(Contact("chat","Noir","https://static.wikia.nocookie.net/miraculousladybug/images/a/af/Chat_Noir_Carr%C3%A9.webp/revision/latest?cb=20210627214552&path-prefix=fr"));
        contacts.add(Contact("lady","Bug","https://static.wikia.nocookie.net/lady-bug/images/8/85/Ladybug_Sentimonster_square.png/revision/latest?cb=20200930060841"));
        contacts.add(Contact("dog","mess","https://static.wikia.nocookie.net/lady-bug/images/e/e5/Barkk_Square.png/revision/latest/top-crop/width/360/height/360?cb=20210914092727"));
        contacts.add(Contact("Rena","Rouge","https://i.pinimg.com/564x/64/35/6b/64356b64eae1a78d5864f3e6e052edd8.jpg"));
        contacts.add(Contact("Queen","Bee","https://static.wikia.nocookie.net/lady-bug/images/a/ae/Queen_Bee_Square_1.png/revision/latest?cb=20200213035020"));
        contacts.add(Contact("pig","momo","https://static.wikia.nocookie.net/lady-bug/images/7/74/Daizzi_Square_2.png/revision/latest?cb=20210914092354"));
        contacts.add(Contact("dog","mess","https://static.wikia.nocookie.net/lady-bug/images/e/e5/Barkk_Square.png/revision/latest/top-crop/width/360/height/360?cb=20210914092727"));
        contacts.add(Contact("Rena","Rouge","https://i.pinimg.com/564x/64/35/6b/64356b64eae1a78d5864f3e6e052edd8.jpg"));
        val adapter : ContactsAdapter = ContactsAdapter(contacts)
        rvContacts.adapter = adapter;
        rvContacts.layoutManager = LinearLayoutManager(this)
    }
}