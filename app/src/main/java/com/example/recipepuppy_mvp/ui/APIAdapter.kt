package com.example.recipepuppy_mvp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recipepuppy_mvp.R
import com.example.recipepuppy_mvp.model.Data
import okhttp3.Response

class APIAdapter : RecyclerView.Adapter<APIAdapter.RecipeViewHolder>() {


    private val data = arrayListOf<Data>()

    fun setData(items: List<Data>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data_ingred, parent, false)
        return RecipeViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RecipeViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    class RecipeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Data) {
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            tvTitle.text = data.title
            val tvIngredients = view.findViewById<TextView>(R.id.tvIngredients)
            tvIngredients.text = data.ingredients

        }
    }

}