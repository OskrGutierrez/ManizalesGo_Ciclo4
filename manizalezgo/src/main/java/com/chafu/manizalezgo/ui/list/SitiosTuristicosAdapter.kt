package com.chafu.manizalezgo.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chafu.manizalezgo.R
import com.chafu.manizalezgo.model.SitioTuristicoItem

import com.squareup.picasso.Picasso

class SitiosTuristicosAdapter(

    private val sitiosTuristicosLista:ArrayList<SitioTuristicoItem>,
    private val onItemClicked: (SitioTuristicoItem) -> Unit) :
    RecyclerView.Adapter<SitiosTuristicosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_sitioturistico_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitioturistico = this.sitiosTuristicosLista[position]
        holder.itemView.setOnClickListener{onItemClicked(sitiosTuristicosLista[position])}
        holder.bind(sitioturistico)
    }

    override fun getItemCount(): Int {
        return this.sitiosTuristicosLista.size

    }

    fun appendItems(newItems: ArrayList<SitioTuristicoItem>) {
        sitiosTuristicosLista.clear()
        sitiosTuristicosLista.addAll(newItems)
        notifyDataSetChanged()

    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        private var sitioTuristicoTextView: TextView = itemview.findViewById(R.id.sitio_turistico_text_view)
        private var descripcionSTTextView: TextView = itemview.findViewById(R.id.descripcion_st_text_view)
        private var puntuacionTextView: TextView = itemview.findViewById(R.id.puntuacion_text_view)
        private var pictureImageView: ImageView = itemview.findViewById(R.id.mainpicture_image_view)
        private var precioTextView: TextView = itemview.findViewById(R.id.price_text_view)

        fun bind(sitioturistico: SitioTuristicoItem){

            this.sitioTuristicoTextView.text     =   sitioturistico.nombreST
            this.descripcionSTTextView.text      =   sitioturistico.descripcionST
            this.puntuacionTextView.text         =   sitioturistico.puntuacion
            this.precioTextView.text             = sitioturistico.precio
            Picasso.get().load(sitioturistico.urlPicture).into(pictureImageView)

        }
    }
}