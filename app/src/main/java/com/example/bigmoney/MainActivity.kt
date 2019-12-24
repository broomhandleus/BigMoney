package com.example.bigmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bottomBarListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.charts -> {
                println("charts pressed")
                return@OnNavigationItemSelectedListener true
            }
            R.id.add_money -> {
                println("add money pressed")
                return@OnNavigationItemSelectedListener true
            }
            R.id.settings -> {
                println("settings pressed")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_bar.setOnNavigationItemSelectedListener(bottomBarListener)
    }

}
