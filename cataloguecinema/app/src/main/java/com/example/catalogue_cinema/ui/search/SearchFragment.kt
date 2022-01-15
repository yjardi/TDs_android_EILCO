package com.example.catalogue_cinema.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogue_cinema.*
import com.example.catalogue_cinema.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var app = (root.context.applicationContext as cataloguecinema)
        val service = Retrofit.Builder()
            .baseUrl(service.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service::class.java)
        binding.Button.setOnClickListener {
            service.searchfilms(binding.textE.text.toString(),app.langue).enqueue(object: Callback<films> {
                override fun onResponse(call: Call<films>, response: Response<films>) {

                    //     afficherfilms(response.body())
                    response.body()?.let { affichefilms(it) }

                }

                override fun onFailure(call: Call<films>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }






        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun affichefilms(films: films) {

        val contacts : MutableList<film> = ArrayList<film>()
        val recyclerView: RecyclerView = binding.rvfilmS

        //Toast.makeText(this, "nombre de dépots : " + repos.size, Toast.LENGTH_SHORT).show()
        for(film in films.results!!){
            if (film != null) {

                contacts.add(film)

            }
        }
        val adapter : adapteur = adapteur(contacts)
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = GridLayoutManager(binding.root.context,2)

    }
}