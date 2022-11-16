package com.example.win13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win13.databinding.ActivityMainBinding
import com.example.win13.databinding.FragmentMainBinding
import com.example.win13.model.RankingMenTeams
import com.example.win13.model.Rankingmenteam
import com.example.win13.retrofit.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainFragment : Fragment() {

    private lateinit var mainBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = FragmentMainBinding.inflate(layoutInflater)
        return mainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            val api = RetrofitApi::class.java
            val retrofitApi = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
            val list = ArrayList<Rankingmenteam>()
            val response = retrofitApi.getTeams().awaitResponse()
            if (response.isSuccessful) {
                list.addAll(response.body()!!.rankingmenteams)
            }
            launch(Dispatchers.Main) {
                val recyclerView = mainBinding.teamRecycler
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = TeamAdapter(list)
            }
        }

    }
}