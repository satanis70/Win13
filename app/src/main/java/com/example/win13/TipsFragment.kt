package com.example.win13

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win13.databinding.FragmentTipsBinding
import com.example.win13.model.Volleyballbetting
import com.example.win13.retrofit.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class TipsFragment : Fragment() {

    private lateinit var tipsBinding: FragmentTipsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tipsBinding = FragmentTipsBinding.inflate(layoutInflater)
        return tipsBinding.root
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
            val list = ArrayList<Volleyballbetting>()
            val response = retrofitApi.getTips().awaitResponse()
            if (response.isSuccessful){
                list.addAll(response.body()!!.volleyballbetting)
            }
            launch(Dispatchers.Main){
                Log.i("list", list.toString())
                val recyclerView = tipsBinding.tipsRecycler
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = TipsAdapter(list)
            }
        }
    }
}