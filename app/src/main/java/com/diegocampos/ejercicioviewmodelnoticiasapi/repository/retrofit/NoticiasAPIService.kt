package com.diegocampos.ejercicioviewmodelmvvmapi.repository.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NoticiasAPIService {

    @Headers(
        value = [
            "X-Api-Key: 5edc249e4f654c9eb94b951609005958",
            "content-type: application/json; charset=utf-8"
        ]
    )
    @GET("everything?q=chile")
    fun obtenerNoticias(@Query("language") languages: String): Call<Noticias>

}