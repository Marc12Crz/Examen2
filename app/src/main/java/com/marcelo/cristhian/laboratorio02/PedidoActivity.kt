package com.marcelo.cristhian.laboratorio02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcelo.cristhian.laboratorio02.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir los datos enviados desde Ejercicio02
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar los datos en la UI
        binding.tvNombreCliente.text = "$nombreCliente"
        binding.tvNumeroCliente.text = " $numeroCliente"
        binding.tvProductos.text = " $productos"
        binding.tvUbicacion.text = " $direccion"

        // Acciones de los botones
        binding.btnLlamar.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intentLlamar)
        }

        binding.btnWsp.setOnClickListener {
            val intentWhatsApp = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$numeroCliente?text=Hola%20$nombreCliente,%20Tus%20productos:%20$productos%20están%20en%20camino%20a%20la%20dirección:%20$direccion")
            }
            startActivity(intentWhatsApp)
        }

        binding.btnMaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$direccion")
            }
            startActivity(intentMaps)
        }
    }
}
