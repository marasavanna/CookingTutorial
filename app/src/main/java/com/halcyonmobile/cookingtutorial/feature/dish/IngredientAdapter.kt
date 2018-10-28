package com.halcyonmobile.cookingtutorial.feature.dish

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.halcyonmobile.cookingtutorial.databinding.IngredientItemViewBinding
import com.halcyonmobile.cookingtutorial.model.Ingredient

class IngredientAdapter(private val ingredients: ArrayList<Ingredient> = ArrayList()) : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IngredientItemViewBinding.inflate(inflater, parent, false)
        return IngredientViewHolder(binding)
    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredients[position], position)
    }


    inner class IngredientViewHolder(private val binding: IngredientItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: Ingredient, position: Int) {
            with(binding) {
                binding.ingredient = ingredient
            }
        }
    }
}