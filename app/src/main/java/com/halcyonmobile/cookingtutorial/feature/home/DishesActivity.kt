package com.halcyonmobile.cookingtutorial.feature.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.halcyonmobile.cookingtutorial.*
import com.halcyonmobile.cookingtutorial.data.CookingTutorialApplication
import com.halcyonmobile.cookingtutorial.databinding.ActivityDishesBinding
import com.halcyonmobile.cookingtutorial.storage.DishRepository
import com.halcyonmobile.cookingtutorial.util.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_dishes.*
import javax.inject.Inject

class DishesActivity : AppCompatActivity() {

    @Inject
    lateinit var dishRepository: DishRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDishesBinding = DataBindingUtil.setContentView(this, R.layout.activity_dishes)

        CookingTutorialApplication.getAppComponent().inject(this)

        binding.viewModel = DishesActivityViewModel(dishRepository)

        dishesRecyclerView.layoutManager = LinearLayoutManager(this)
        dishesRecyclerView.adapter = binding.viewModel!!.adapter
        dishesRecyclerView.setHasFixedSize(true)

        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = dishesRecyclerView.adapter as DishesAdapter
                adapter.removeItemAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(dishesRecyclerView)

        binding.addDish.setOnClickListener {
            (dishesRecyclerView.adapter as DishesAdapter).addItem()
            dishesRecyclerView.smoothScrollToPosition(dishesRecyclerView.adapter.itemCount - 1)
        }
    }
}
