package com.gonzales.cesar.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PedidoActivity : AppCompatActivity() {

    lateinit var nombreCliente: String
    lateinit var numeroCliente: String
    lateinit var productos: String
    lateinit var direccion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        // Obtener los datos enviados desde MainActivity
        nombreCliente = intent.getStringExtra("nombre_cliente").toString()
        numeroCliente = intent.getStringExtra("numero_cliente").toString()
        productos = intent.getStringExtra("productos").toString()
        direccion = intent.getStringExtra("direccion").toString()

        // Mostrar los datos en la interfaz
        val tvNombreCliente: TextView = findViewById(R.id.tv_nombre_cliente)
        val tvNumeroCliente: TextView = findViewById(R.id.tv_numero_cliente)
        val tvProductos: TextView = findViewById(R.id.tv_productos)
        val tvDireccion: TextView = findViewById(R.id.tv_direccion)

        tvNombreCliente.text = "Nombre Cliente: $nombreCliente"
        tvNumeroCliente.text = "Número Cliente: $numeroCliente"
        tvProductos.text = "Productos: $productos"
        tvDireccion.text = "Dirección: $direccion"

        // Botones para las acciones
        val btnLlamar: Button = findViewById(R.id.btn_llamar)
        val btnWhatsApp: Button = findViewById(R.id.btn_wsp)
        val btnMaps: Button = findViewById(R.id.btn_maps)

        // Asignar las funciones a los botones
        btnLlamar.setOnClickListener { llamarTelefono() }
        btnWhatsApp.setOnClickListener { enviarWhatsApp() }
        btnMaps.setOnClickListener { abrirMaps() }
    }

    // Función para hacer una llamada al número del cliente
    fun llamarTelefono() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$numeroCliente")
        startActivity(intent)
    }

    // Función para enviar un mensaje de WhatsApp al cliente
    fun enviarWhatsApp() {
        val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$numeroCliente&text=$mensaje")

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    // Función para abrir la ubicación en Google Maps
    fun abrirMaps() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
        startActivity(intent)
    }
}