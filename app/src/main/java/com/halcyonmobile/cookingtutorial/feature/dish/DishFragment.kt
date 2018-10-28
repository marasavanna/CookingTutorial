package com.halcyonmobile.cookingtutorial.feature.dish

import android.arch.lifecycle.ViewModelProviders
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
import com.halcyonmobile.cookingtutorial.databinding.FragmentDishBinding
import com.halcyonmobile.cookingtutorial.util.SwipeToDeleteCallback
import javax.inject.Inject

class DishFragment : CookingTutorialFragment() {

    lateinit var binding: FragmentDishBinding
    @Inject
    lateinit var dishActivityViewModelFactory: DishActivityViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dish, container, false)
        val viewModel = ViewModelProviders.of(this@DishFragment, dishActivityViewModelFactory)
                .get(DishesActivityViewModel::class.java)
        viewModel.selectDishesByCategory(arguments!!.getString(CATEGORY_EXTRA))
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

    companion object {
        private const val CATEGORY_EXTRA = "categoryName"
        fun newInstance(categoryName: String) = DishFragment().apply {
            arguments = Bundle().apply {
                putString(CATEGORY_EXTRA, categoryName)
            }
        }
    }
}