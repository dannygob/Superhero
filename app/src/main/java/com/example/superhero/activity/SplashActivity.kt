package com.example.superhero.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen // Cambio correcto de importación
import com.bumptech.glide.Glide
import com.example.superhero.R
import com.example.superheroleague.activities.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val splashScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instalar el splash screen en Android 12+
        SplashScreen.installSplashScreen()

        // Vincular con el layout del splash
        setContentView(R.layout.activity_splash)

        // Referencia al ImageView del GIF
        val gifImageView = findViewById<ImageView>(R.id.gifImageView)

        // Cargar GIFs y avanzar a MainActivity
        splashScope.launch {
            showGIFsConsecutivos(gifImageView)
            delay(2000) // Pequeña espera extra para estabilidad
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish() // Cierra el splash correctamente
        }
    }

    // Función para mostrar los GIFs con Glide
    private suspend fun showGIFsConsecutivos(gifImageView: ImageView) {
        Glide.with(this@SplashActivity)
            .asGif()
            .load(R.drawable.clip) // GIF inicial
            .into(gifImageView)
        delay(1500) // Espera antes de la transición

//        // Cargar GIFs opcionales (si los usas)
//        Glide.with(this@SplashActivity)
//            .asGif()
//            .load(R.drawable.dc1)
//            .into(gifImageView)
//        delay(1500)
//
//        Glide.with(this@SplashActivity)
//            .asGif()
//            .load(R.drawable.dc2)
//            .into(gifImageView)
//        delay(1500)
    }

    override fun onDestroy() {
        splashScope.cancel() // Cancelar tareas pendientes
        super.onDestroy()
    }
}


