package com.example.cocktailmenu.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmenu.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvCocktail: RecyclerView
//    private val list: ArrayList<CocktailMenu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCocktail = findViewById(R.id.rv_main)
        rvCocktail.setHasFixedSize(true)

//        list.addAll(getlistCocktailMenu)
//        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


}