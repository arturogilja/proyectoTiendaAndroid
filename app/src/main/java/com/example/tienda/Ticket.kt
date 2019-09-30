package com.example.tienda


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_carrito.*
import kotlinx.android.synthetic.main.fragment_ticket.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Ticket(val ticket : ArrayList<ProductoTicket>, val onClickInterface: OnClickInterface) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewTicket.adapter = AdapterTicket(ticket)
        var subtotal : Double = 0.0
        this.ticket.forEach { producto: ProductoTicket ->
            subtotal += producto.cantidad * producto.producto.precio
        }
        var iva = subtotal * 0.16
        iva = "%.2f".format(iva).toDouble()
        var total = subtotal + iva

        ticketSubtotal.text = "$ $subtotal"
        ticketIva.text = "$ $iva"
        ticketTotal.text = "$ $total"

        volverATienda.setOnClickListener {
            onClickInterface.onVolverAComprar()
        }

    }


}
