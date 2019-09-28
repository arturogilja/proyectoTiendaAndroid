package com.example.tienda

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdapterTicket(val list: ArrayList<ProductoTicket>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): ProductoTicket {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        val listView = LayoutInflater.from(parent.context).inflate(R.layout.ticket_element, parent, false)

        val cantidad = list[position].cantidad
        val producto = list[position].producto

        listView.findViewById<TextView>(R.id.ticketElementoCantidad).text = cantidad.toString()
        listView.findViewById<TextView>(R.id.ticketElementoNombre).text = producto.nombre
        listView.findViewById<TextView>(R.id.ticketElementoTotal).text = "$ ${cantidad * producto.precio}"

        return listView
    }
}