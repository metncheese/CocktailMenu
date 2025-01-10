package com.example.cocktailmenu.adapter

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmenu.data.CocktailsMenu

class CocktailsMenuListAdapter(private val cocktailsList: ArrayList<CocktailsMenu>) : RecyclerView.Adapter<CocktailsMenuListAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.content_img)
        val tvName: TextView = itemView.findViewById(R.id.cocktail_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cocktail_menu, parent, false)
        return ListViewHolder(view) // Fix return statement
    }


    override fun getItemCount(): Int = cocktailsList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = cocktailsList[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(cocktailsList[holder.adapterPosition])
            Toast.makeText(holder.itemView.context, "You selected" + cocktailsList[holder.adapterPosition], Toast.LENGTH_SHORT).show()
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: CocktailsMenu)
    }
}