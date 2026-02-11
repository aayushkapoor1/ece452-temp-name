package com.stelli.app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/** Backend base URL: 10.0.2.2 is host machine from emulator; use your machine's IP for a physical device. */
private const val BASE_URL = "http://10.0.2.2:8000/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val stelliApi: StelliApi = retrofit.create(StelliApi::class.java)

interface StelliApi {
    @GET("api/spots")
    suspend fun getSpots(): List<StudySpot>
}

data class StudySpot(
    val id: Int,
    val name: String,
    val location: String,
    val description: String?
)
