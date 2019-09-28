package com.example.tienda

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), OnClickInterface{

    lateinit var productos: ArrayList<Producto>
    var carrito: ArrayList<Producto> = ArrayList()


    override fun onAgregar(producto: Producto) {
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar")
            .setMessage("Deseas añadir el producto \"${producto.nombre}\"? ")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface, i: Int ->
                carrito.add(producto)
            }.setNegativeButton("Cancelar") { dialogInterface: DialogInterface, i: Int ->

            }
        builder.create().show()
    }

    override fun onComprar() {


        val ticket = ArrayList<ProductoTicket>()

        productos.forEach { producto ->
            var total = 0
            carrito.forEach { productoCarrito ->
                if(producto.nombre.equals(productoCarrito.nombre))
                    total++
            }
            if(total > 0)
                ticket.add(ProductoTicket(total, producto))
        }

        var ticketFragment = Ticket(ticket, this)
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentActivity, ticketFragment)
        fragmentTransaction.commit()
    }

    override fun onVerCarrito() {
        var carritoFragment = Carrito(this.carrito, this)
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentActivity, carritoFragment)

        fragmentTransaction.commit()
    }

    override fun onRegresarATienda() {
        var productosFragment = Productos(this.productos, this)
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentActivity, productosFragment)

        fragmentTransaction.commit()
    }

    override fun onVolverAComprar() {
        this.carrito = ArrayList()
        var productosFragment = Productos(this.productos, this)
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentActivity, productosFragment)

        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productos = ArrayList<Producto>()
        this.productos.add(Producto("Horizon Zero Dawn", 830.0, "https://www.bigw.com.au/medias/sys_master/images/images/h77/h7e/13741881098270.jpg"))
        this.productos.add(Producto("The Last Of Us", 320.0, "https://cdn.cetrogar.com.ar/media/catalog/product/cache/1/image/1200x/9df78eab33525d08d6e5fb8d27136e95/E/L/EL2168_1.jpg"))
        this.productos.add(Producto("Spiderman", 900.0, "https://media.gamestop.com/i/gamestop/10131620/Marvels-Spider-Man"))
        this.productos.add(Producto("God Of War", 610.0, "https://assets1.ignimgs.com/2018/04/17/god-of-war-m-rating-1524001660097.jpg?fit=bounds&dpr=1&quality=75&width=188px"))
        this.productos.add(Producto("Detroit Become Human", 870.0, "https://images-na.ssl-images-amazon.com/images/I/91ycevtk26L._SL1500_.jpg"))
        this.productos.add(Producto("Uncharted 4", 400.0, "https://static.bhphoto.com/images/images2000x2000/1531315355_1419657.jpg"))
        this.productos.add(Producto("Days Gone", 900.0, "https://www.mobygames.com/images/covers/l/555459-days-gone-playstation-4-front-cover.jpg"))
        this.productos.add(Producto("FIFA 20", 1350.0, "https://www.thesun.co.uk/wp-content/uploads/2019/06/NINTCHDBPICT000508759379.jpg"))
        this.productos.add(Producto("Rainbow Six Siege", 400.0, "https://images-na.ssl-images-amazon.com/images/I/81YGBJFzZ-L._SL1500_.jpg"))
        this.productos.add(Producto("Grand Theft Auto 5", 735.0, "https://images-na.ssl-images-amazon.com/images/I/916T5H6sCtL._SL1500_.jpg"))


        var productosFragment = Productos(this.productos, this)
        var fragmentManager = supportFragmentManager

        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentActivity, productosFragment)

        fragmentTransaction.commit()
//
//        var carritoFragment = Carrito(this.productos)
//        var fragmentManager = supportFragmentManager
//        var fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.fragmentActivity, carritoFragment)
//        fragmentTransaction.commit()
    }
}
