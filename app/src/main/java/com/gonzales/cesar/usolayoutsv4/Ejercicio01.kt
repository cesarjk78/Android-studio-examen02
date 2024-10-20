package com.gonzales.cesar.usolayoutsv4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gonzales.cesar.usolayoutsv4.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater) // Inflar el binding
        setContentView(binding.root) // Configurar la vista con el binding

        // Botón Mostrar
        binding.buttonMostrar.setOnClickListener {
            binding.viewVerde.visibility = View.VISIBLE
        }

        // Botón Ocultar
        binding.buttonOcultar.setOnClickListener {
            binding.viewVerde.visibility = View.GONE
        }
    }
}
