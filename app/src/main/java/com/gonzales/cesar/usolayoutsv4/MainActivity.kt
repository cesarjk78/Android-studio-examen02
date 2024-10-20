package com.gonzales.cesar.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etNombreCliente: EditText
    lateinit var etNumeroCliente: EditText
    lateinit var etProductos: EditText
    lateinit var etCiudad: EditText
    lateinit var etDireccion: EditText
    lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa los campos de texto y el botón
        etNombreCliente = findViewById(R.id.et_nombre_cliente)
        etNumeroCliente = findViewById(R.id.et_numero_cliente)
        etProductos = findViewById(R.id.et_productos)
        etCiudad = findViewById(R.id.et_ciudad)
        etDireccion = findViewById(R.id.et_direccion)
        btnRegistrar = findViewById(R.id.btn_registrar)

        // Acciones al hacer clic en el botón de registrar
        btnRegistrar.setOnClickListener {
            if (validarCampos()) {
                // Crear un Intent explícito para ir a PedidoActivity y pasar los datos
                val intent = Intent(this, PedidoActivity::class.java)
                intent.putExtra("nombre_cliente", etNombreCliente.text.toString())
                intent.putExtra("numero_cliente", etNumeroCliente.text.toString())
                intent.putExtra("productos", etProductos.text.toString())
                intent.putExtra("direccion", etDireccion.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Validar que todos los campos están llenos
    private fun validarCampos(): Boolean {
        return etNombreCliente.text.isNotEmpty() &&
                etNumeroCliente.text.isNotEmpty() &&
                etProductos.text.isNotEmpty() &&
                etCiudad.text.isNotEmpty() &&
                etDireccion.text.isNotEmpty()
    }
}
