package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halcyonmobile.cookingtutorial.R
import com.halcyonmobile.cookingtutorial.architecture.CookingTutorialFragment
import com.halcyonmobile.cookingtutorial.databinding.ActivityDishesBinding
import com.halcyonmobile.cookingtutorial.storage.DishRepository
import com.halcyonmobile.cookingtutorial.util.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_dishes.*
import javax.inject.Inject

class HomeFragment : CookingTutorialFragment() {

    private lateinit var binding: ActivityDishesBinding

    @Inject
    lateinit var dishActivityViewModelFactory: DishActivityViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_dishes, container, false)
        val viewModel = ViewModelProviders.of(this@HomeFragment, dishActivityViewModelFactory)
                .get(DishesActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.dishesRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.dishesRecyclerView.adapter = binding.viewModel!!.adapter
        binding.dishesRecyclerView.setHasFixedSize(true)

        val swipeHandler = object : SwipeToDeleteCallback(binding.root.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = binding.dishesRecyclerView.adapter as DishesAdapter
                adapter.removeItemAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.dishesRecyclerView)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addDish.setOnClickListener {
            (dishesRecyclerView.adapter as DishesAdapter).addItem()
            dishesRecyclerView.smoothScrollToPosition(dishesRecyclerView.adapter.itemCount - 1)
        }
    }
}