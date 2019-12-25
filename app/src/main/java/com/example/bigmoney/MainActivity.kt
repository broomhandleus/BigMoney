package com.example.bigmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bottomBarListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        loadFragment(item.itemId)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_bar.setOnNavigationItemSelectedListener(bottomBarListener)
    }

    // TODO: Implement the OnFragmentInteractinListener

    private fun loadFragment(itemId: Int) {
        val tag = itemId.toString()
        var fragment = supportFragmentManager.findFragmentByTag(tag) ?: when (itemId) {
            R.id.charts -> {
                println("Starting up a Chart Fragment")
                ChartFragment.newInstance()
            }
            R.id.add_money -> {
                println("Starting up an Add Money Fragment")
                AddFragment.newInstance()
            }
            R.id.settings -> {
                println("Starting up a Settings Fragment")
                SettingsFragment.newInstance()
            }
            else -> {
                null
            }
        }

        // replace fragment
        if (fragment != null) {
            println("fragment is not null. Check new instance method")
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit()
        }
    }
}
