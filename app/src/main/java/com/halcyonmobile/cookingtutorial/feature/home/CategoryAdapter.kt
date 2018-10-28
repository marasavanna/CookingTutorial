package com.halcyonmobile.cookingtutorial.feature.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.halcyonmobile.cookingtutorial.feature.dish.DishFragment

class CategoryAdapter(fm: FragmentManager?, private var categories: ArrayList<String>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return DishFragment.newInstance(categories[position])
    }
    override fun getCount(): Int {
        return categories.size
    }
    override fun getPageTitle(position: Int) = categories[position]
}