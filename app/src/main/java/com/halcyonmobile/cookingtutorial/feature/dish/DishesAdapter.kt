package com.halcyonmobile.cookingtutorial.feature.dish

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.halcyonmobile.cookingtutorial.databinding.DishItemViewBinding
import com.halcyonmobile.cookingtutorial.methods.goToVideo
import com.halcyonmobile.cookingtutorial.model.Dish
import com.halcyonmobile.cookingtutorial.model.Ingredient

class DishesAdapter(private var dishesList: ArrayList<Dish> = ArrayList()) : RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {

    private var lastPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DishItemViewBinding.inflate(inflater, parent, false)
        return DishesViewHolder(binding)

    }

    override fun getItemCount(): Int = dishesList.size

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        holder.bind(dishesList[position])

        setAnimation(holder.itemView, position)
    }

    fun setDishList(dishes: ArrayList<Dish>) {
        dishesList = dishes
    }

    fun removeItemAt(position: Int) {
        dishesList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addItem() {
        dishesList.add(Dish("", "Mara", null, 2, 1.4, null))
        notifyItemInserted(dishesList.size - 1)

    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    inner class DishesViewHolder(private val binding: DishItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        private var wasClicked: Int = 1
        val orientation: Int = binding.root.resources.configuration.orientation

        private fun determineSpanCountByOrientation(): Int = if (orientation == 1) {
            3
        } else {
            4
        }

        fun bind(dishItem: Dish) {
            val ingredientsPerDish: ArrayList<Ingredient>? = dishItem.ingredients
            binding.ingredientsRecyclerView.layoutManager = GridLayoutManager(binding.root.context, determineSpanCountByOrientation())
            binding.ingredientsRecyclerView.adapter = ingredientsPerDish?.let { IngredientAdapter(it) }
            binding.ingredientsRecyclerView.setHasFixedSize(true)
            with(binding) {
                binding.dishItem = dishItem
                binding.dishCard.setOnClickListener {
                    if (wasClicked % 2 == 1) {
                        binding.calories.visibility = View.VISIBLE
                        binding.numberCalories.visibility = View.VISIBLE
                        binding.preparationTime.visibility = View.VISIBLE
                        binding.numberCalories.visibility = View.VISIBLE
                        binding.difficulty.visibility = View.VISIBLE
                        binding.difficultyRating.visibility = View.VISIBLE
                        binding.timeToMake.visibility = View.VISIBLE
                        binding.ingredientsRecyclerView.visibility = View.VISIBLE
                        wasClicked++
                    } else {
                        binding.calories.visibility = View.GONE
                        binding.numberCalories.visibility = View.GONE
                        binding.preparationTime.visibility = View.GONE
                        binding.numberCalories.visibility = View.GONE
                        binding.difficulty.visibility = View.GONE
                        binding.difficultyRating.visibility = View.GONE
                        binding.timeToMake.visibility = View.GONE
                        binding.ingredientsRecyclerView.visibility = View.GONE
                        wasClicked++
                    }
                }
                binding.dishCard.setOnLongClickListener {
                    goToVideo(binding.root.context, binding.dishName.text.toString())
                    return@setOnLongClickListener true
                }
            }
        }
    }
}