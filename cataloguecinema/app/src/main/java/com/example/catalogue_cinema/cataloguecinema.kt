package com.example.catalogue_cinema
import android.app.Application
class cataloguecinema:Application() {
    var langue: String = ""
    override fun onCreate() {
        super.onCreate()
        this.langue = "en-US"
    }

}