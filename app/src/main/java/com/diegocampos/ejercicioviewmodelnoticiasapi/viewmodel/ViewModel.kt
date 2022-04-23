package com.diegocampos.ejercicioviewmodelnoticiasapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegocampos.ejercicioviewmodelmvvmapi.repository.retrofit.Noticias
import com.diegocampos.ejercicioviewmodelnoticiasapi.repository.interactor.NoticiasInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun onBtnTraerNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta("es"))
        }
    }


}