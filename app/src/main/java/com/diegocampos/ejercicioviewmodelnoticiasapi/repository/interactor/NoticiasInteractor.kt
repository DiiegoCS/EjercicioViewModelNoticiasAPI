package com.diegocampos.ejercicioviewmodelnoticiasapi.repository.interactor

import com.diegocampos.ejercicioviewmodelmvvmapi.repository.retrofit.Noticias
import com.diegocampos.ejercicioviewmodelmvvmapi.repository.retrofit.NoticiasAPIService
import com.diegocampos.ejercicioviewmodelmvvmapi.repository.retrofit.RestEngine
import retrofit2.Call

class NoticiasInteractor {

    fun traerRespuesta(languages: String): Noticias?{
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }
}