package com.marcelo.cristhian.laboratorio02

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.marcelo.cristhian.laboratorio02.databinding.ActivityEjercicio01Binding

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnMostrar.setOnClickListener {
            binding.cardViewVerde.visibility = View.VISIBLE
        }


        binding.btnOcultar.setOnClickListener {
            binding.cardViewVerde.visibility = View.GONE
        }
    }
}
