package com.example.tienda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.ArrayList


class AdapterRecycler(internal var list: ArrayList<Producto>, val clickInterface: OnClickInterface) :
RecyclerView.Adapter<AdapterRecycler.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecycler.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.producto_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRecycler.ViewHolder, position: Int) {
        val nombre = list[position].nombre
        val precio = list[position].precio
        val imagen = list[position].imagen

        holder.nombre.text = nombre
        holder.precio.text = "$ $precio"
        Picasso.get().load(imagen).into(holder.imagen)

        holder.agregar.setOnClickListener {
            clickInterface.onAgregar(Producto(nombre, precio, imagen))
        }

        val view = holder.itemView
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var nombre: TextView = itemView.findViewById(R.id.nombreElemento)
        internal var precio: TextView = itemView.findViewById(R.id.precioElemento)
        internal var imagen: ImageView = itemView.findViewById(R.id.imagenElemento)
        internal var agregar : Button = itemView.findViewById(R.id.addBoton)
    }


}