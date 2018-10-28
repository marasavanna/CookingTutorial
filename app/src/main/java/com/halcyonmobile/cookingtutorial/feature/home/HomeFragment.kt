package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halcyonmobile.cookingtutorial.R
import com.halcyonmobile.cookingtutorial.architecture.CookingTutorialFragment
import com.halcyonmobile.cookingtutorial.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : CookingTutorialFragment() {

    @Inject
    lateinit var homeFragmentViewModelFactory: HomeFragmentViewModelFactory

    private lateinit var binding: FragmentHomeBinding
    private var dishCategories: ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val viewModel = ViewModelProviders.of(this, homeFragmentViewModelFactory).get(HomeFragmentViewModel::class.java)
                .apply {
                    categories.observe(this@HomeFragment, Observer {
                        dishCategories = it!!
                        binding.categoriesViewPager.adapter = CategoryAdapter(fragmentManager, dishCategories)
                    })
                }

        binding.dishCategories.setupWithViewPager(binding.categoriesViewPager)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
    }
}