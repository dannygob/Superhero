package com.example.superhero.activity

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superhero.R
import com.example.superhero.adapters.SuperheroAdapter
import com.example.superhero.data.Superhero
import com.example.superhero.utils.SuperheroService
import com.example.superhero.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    //lateinit var superhero: SuperheroAdapter
    lateinit var adapter: SuperheroAdapter

    var superheroList: List<Superhero> = emptyList()

   // lateinit var recyclerView: RecyclerView
   //lateinit var adapter: SuperheroAdapter
   // var superheroList: List<Superhero> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //recyclerView = findViewById(R.id.recyclerView)

        adapter = SuperheroAdapter(superheroList) { position ->
            val superhero = superheroList[position]

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.SUPERHERO_ID, superhero.id)
            startActivity(intent)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        searchSuperheroesByName("a")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)

        val menuItem = menu.findItem(R.id.menu_search)
        val searchView = menuItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchSuperheroesByName(query)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                return false
            }
        })

        return true
    }

//    fun getRetrofit(): SuperheroService {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://www.superheroapi.com/api.php/7252591128153666/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(SuperheroService::class.java)
//    }

    fun searchSuperheroesByName(query: String) {

        //llamada a un hilo secundario
        CoroutineScope(Dispatchers.IO).launch {
            try {
//                val service = getRetrofit()
                val service = SuperheroService.getInstance()
                val response = service.findSuperheroesByName(query)
                superheroList = response.results

                //volvemos al hilo principal
                CoroutineScope(Dispatchers.Main).launch {
//                    adapter.items = superheroList
//                    adapter.notifyDataSetChanged()
                    adapter.updateItems(superheroList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}