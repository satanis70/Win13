package com.example.win13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win13.databinding.FragmentVocabularyBinding
import com.example.win13.model.Vocabulary
import com.example.win13.retrofit.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


class VocabularyFragment : Fragment() {

    private lateinit var vocabularyBinding: FragmentVocabularyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vocabularyBinding = FragmentVocabularyBinding.inflate(layoutInflater)
        return vocabularyBinding.root
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
            val list = ArrayList<Vocabulary>()
            val response = retrofitApi.getVocabulary().awaitResponse()
            if(response.isSuccessful){
                list.addAll(response.body()!!.vocabulary)
            }
            launch(Dispatchers.Main) {
                val recyclerView = vocabularyBinding.vocabularyRecycler
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = VocabularyAdapter(list)
            }
        }
    }
}