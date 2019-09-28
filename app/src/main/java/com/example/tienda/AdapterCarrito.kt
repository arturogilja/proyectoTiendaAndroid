package com.example.tienda

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterCarrito(val list: ArrayList<Producto>) : BaseAdapter() {


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Producto {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val listView = LayoutInflater.from(parent.context).inflate(R.layout.carrito_element, parent, false)

        val imagen = list[position].imagen
        val nombre = list[position].nombre
        val precio = list[position].precio

        Picasso.get().load(imagen).into(listView.findViewById<ImageView>(R.id.imagenCarrito))
        listView.findViewById<TextView>(R.id.nombreCarrito).text = nombre
        listView.findViewById<TextView>(R.id.precioCarrito).text = "$ $precio"


        return listView
    }
}