package com.halcyonmobile.cookingtutorial.feature.shared

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.halcyonmobile.cookingtutorial.R
import com.halcyonmobile.cookingtutorial.architecture.CookingTutorialActivity
import com.halcyonmobile.cookingtutorial.databinding.ActivityMainBinding
import com.halcyonmobile.cookingtutorial.feature.favorites.FavoritesFragment
import com.halcyonmobile.cookingtutorial.feature.home.HomeFragment
import com.halcyonmobile.cookingtutorial.feature.settings.SettingsFragment

class MainActivity : CookingTutorialActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_navigation -> {
                    supportFragmentManager.handleReplace { HomeFragment() }
                    true
                }
                R.id.favorites_navigation -> {
                    supportFragmentManager.handleReplace { FavoritesFragment() }
                    true
                }
                R.id.settings_navigation -> {
                    supportFragmentManager.handleReplace { SettingsFragment() }
                    true
                }
                else -> false
            }
        }
        supportFragmentManager.handleReplace { HomeFragment() }
    }

    private inline fun <reified T : Fragment> FragmentManager.handleReplace(crossinline newInstance: () -> T) {
        beginTransaction()
                .replace(R.id.container, findFragmentByTag(T::class.java.name)
                        ?: newInstance.invoke(), T::class.java.name)
                .commit()
    }
}
