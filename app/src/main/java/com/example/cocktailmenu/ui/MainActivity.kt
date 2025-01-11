package com.example.cocktailmenu.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmenu.R
import com.example.cocktailmenu.adapter.CocktailsMenuListAdapter
import com.example.cocktailmenu.data.CocktailsMenu

class MainActivity : AppCompatActivity() {
    private lateinit var rvCocktail: RecyclerView
    private val list = ArrayList<CocktailsMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCocktail = findViewById(R.id.rv_main)
        rvCocktail.setHasFixedSize(true)

        list.addAll(getListCocktailsMenu())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCocktailsMenu(): ArrayList<CocktailsMenu> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCocktailsMenu = ArrayList<CocktailsMenu>()

        for (i in dataName.indices) {
            val cocktailsMenu = CocktailsMenu(
                name = dataName[i],
                description = dataDescription[i],
                photo = dataPhoto.getResourceId(i, -1)
            )
            listCocktailsMenu.add(cocktailsMenu)
        }
        dataPhoto.recycle()
        return listCocktailsMenu
    }


    private fun showRecyclerList() {
        rvCocktail.layoutManager = LinearLayoutManager(this)
        val cocktailsMenuListAdapter = CocktailsMenuListAdapter(list)
        rvCocktail.adapter = cocktailsMenuListAdapter

        cocktailsMenuListAdapter.setOnItemClickCallback(object: CocktailsMenuListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: CocktailsMenu) {
                showSelectedCocktailsMenu(data)
            }
        }
        )
    }

    private fun showSelectedCocktailsMenu(data: CocktailsMenu) {
        val data = CocktailsMenu(
            data.name, data.description, data.photo
        )
        val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithObjectIntent.putExtra(DetailActivity.key_CocktailsMenu, data)
        startActivity(moveWithObjectIntent)
    }
}