package com.example.win13.retrofit

import com.example.win13.model.RankingMenTeams
import com.example.win13.model.VocabularyModel
import com.example.win13.model.VolleyballBettingModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("/win13/fivbworldrankingmen.json")
    fun getTeams():Call<RankingMenTeams>
    @GET("/win13/volleyballbetting.json")
    fun getTips():Call<VolleyballBettingModel>
    @GET("/win13/vocabulary.json")
    fun getVocabulary():Call<VocabularyModel>
}