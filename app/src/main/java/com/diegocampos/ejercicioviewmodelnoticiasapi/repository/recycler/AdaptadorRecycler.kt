package com.diegocampos.ejercicioviewmodelnoticiasapi.repository.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diegocampos.ejercicioviewmodelnoticiasapi.R
import com.diegocampos.ejercicioviewmodelnoticiasapi.repository.recycler.AdaptadorRecycler.ViewHolderDatos

class AdaptadorRecycler(var context: Context, var listaDatos: ArrayList<EtiquetaNoticia>) :
RecyclerView.Adapter<AdaptadorRecycler.ViewHolderDatos>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_recycler, null, false)
        return ViewHolderDatos(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        holder.titulo.text = listaDatos[position].titulo
        holder.des.text = listaDatos[position].descripcion
        Glide.with(context)
            .load(listaDatos[position].imagen)
            .error(R.drawable.inprogress)
            .into(holder.imagen)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
    class ViewHolderDatos(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imagen: ImageView
        var titulo: TextView
        var des: TextView

        init {
            titulo = itemView.findViewById(R.id.myDato)
            des = itemView.findViewById(R.id.myDes)
           imagen = itemView.findViewById(R.id.myImagen)
        }
    }
}