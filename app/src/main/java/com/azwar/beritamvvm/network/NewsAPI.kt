package com.azwar.beritamvvm.network

import com.azwar.beritamvvm.model.NewsResponse
import com.azwar.beritamvvm.util.Konstans.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String = "id",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apikey:String= API_KEY
    ): Response<NewsResponse>
}