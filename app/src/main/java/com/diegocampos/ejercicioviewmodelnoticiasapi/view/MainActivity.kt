package com.diegocampos.ejercicioviewmodelnoticiasapi.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.diegocampos.ejercicioviewmodelnoticiasapi.R
import com.diegocampos.ejercicioviewmodelnoticiasapi.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var myToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.myNavigationView.setNavigationItemSelectedListener(this)

        myToolbar = findViewById(R.id.myToolbar)

        setSupportActionBar(myToolbar)

        toogle = setDrawerToogle()
        binding.myDrawerLayout.addDrawerListener(toogle)
    }

    private fun setDrawerToogle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(
            this,
            binding.myDrawerLayout,
            myToolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate( savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toogle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var intent: Intent= Intent()
        when (item.itemId) {
            R.id.nav_global ->  intent= Intent(applicationContext, NoticiasGenerales::class.java)
            R.id.nav_buscar ->  intent= Intent(applicationContext, BuscarNoticias::class.java)
        }
        startActivity(intent)

        title = item.title //para mostrar el título
        binding.myDrawerLayout.closeDrawers() //para cerrar drawer

        return true
    }


}