package com.example.superhero.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.superhero.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val splashScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Vinculamos con el layout que contiene el ImageView del GIF
        setContentView(R.layout.activity_splash)

        // Referencia al ImageView donde cargaremos los GIFs
        val gifImageView = findViewById<ImageView>(R.id.gifImageView)

        // Inicia la secuencia de mostrar los GIFs
        showGIFsConsecutivos(gifImageView)

        // Simula la carga de la app y luego pasa a MainActivity
        splashScope.launch {
            delay(8000)  // Espera hasta que los GIFs se hayan mostrado
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }

    // Función para mostrar tres GIFs consecutivos
    private fun showGIFsConsecutivos(gifImageView: ImageView) {
        splashScope.launch {
            // Cargar el primer GIF
            Glide.with(this@SplashActivity)
                .asGif()
                .load(R.drawable.clipeditado) // tu primer GIF
                .into(gifImageView)
            delay(1000) // Espera

            //            // Cargar el segundo GIF
//            Glide.with(this@SplashActivity)
//                .asGif()
//                .load(R.drawable.dc1) // tu segundo GIF
//                .into(gifImageView)
//            delay(1) // Espera
//
//            // Cargar el tercer GIF
//            Glide.with(this@SplashActivity)
//                .asGif()
//                .load(R.drawable.dc2) // tu tercer GIF
//                .into(gifImageView)
//            delay(1) // Espera
//        }
            fun onDestroy() {
                splashScope.cancel() // Cancelar cualquier tarea pendiente
                super.onDestroy()
            }
        }

    }
}



