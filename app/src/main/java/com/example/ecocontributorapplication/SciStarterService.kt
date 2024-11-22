package com.example.ecocontributorapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SciStarterService {

    @GET("api")
    suspend fun getProjects(
        @Header("Authorization") apiKey: String,
        @Query("param") value: String // replace "param" with actual query parameter names
    ): SciStarterResponse

    companion object {
        private const val BASE_URL = "https://scistarter.org/"

        fun create(): SciStarterService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SciStarterService::class.java)
        }
    }
}
