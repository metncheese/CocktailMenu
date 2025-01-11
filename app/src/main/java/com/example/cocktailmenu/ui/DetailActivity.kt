package com.example.cocktailmenu.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailmenu.R
import com.example.cocktailmenu.data.CocktailsMenu

class DetailActivity : AppCompatActivity() {
    companion object {
        const val key_CocktailsMenu: String = "key_CocktailsMenu"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Cocktail Description"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataCocktailsMenu = if (Build.VERSION.SDK_INT >= 34) {
            intent.getParcelableExtra(key_CocktailsMenu, CocktailsMenu::class.java)
        }
        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(key_CocktailsMenu)
        }

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_desc)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_gambar)
        val tvDetailDescriptionLabel = findViewById<TextView>(R.id.tv_cocktail_desc)
        tvDetailDescriptionLabel.text = getString(R.string.description)

        if (dataCocktailsMenu != null) {
            tvDetailName.text = dataCocktailsMenu.name
            tvDetailDescription.text = dataCocktailsMenu.description
            ivDetailPhoto.setImageResource(dataCocktailsMenu.photo)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}