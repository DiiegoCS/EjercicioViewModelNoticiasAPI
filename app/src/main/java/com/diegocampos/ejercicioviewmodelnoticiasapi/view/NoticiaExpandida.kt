package com.diegocampos.ejercicioviewmodelnoticiasapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegocampos.ejercicioviewmodelnoticiasapi.databinding.ActivityMainBinding
import com.diegocampos.ejercicioviewmodelnoticiasapi.databinding.ActivityNoticiaExpandidaBinding

class NoticiaExpandida : AppCompatActivity() {
    private lateinit var binding: ActivityNoticiaExpandidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiaExpandidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}