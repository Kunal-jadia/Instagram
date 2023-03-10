package com.example.instagram.api


import com.example.instagram.models.TotalFeeds
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://picsum.photos/250

//https://pixabay.com/api/?key=33736652-549b254797bbe5c674f31a1d7&q=yellow+flowers&image_type=photo&page=2
const val BASE_URL = "https://pixabay.com/"
const val API_KEY = "33736652-549b254797bbe5c674f31a1d7"
interface FeedService {

    @GET("api/?key=$API_KEY&image_type=photo")
    suspend fun getFeed(@Query("page") page : Int) : Response<TotalFeeds>
}
object RetrofitHelper {
    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
// https://pixabay.com/api/?key=33736652-549b254797bbe5c674f31a1d7&image_type=photo