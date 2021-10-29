package com.akshayteli.kotlinbottomnavigationwithactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.searchFragment,R.id.profileFragment,R.id.settingsFragment))

        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomNavigation.setupWithNavController(navController)

        bottomNavigation.background = null
        bottomNavigation.menu.getItem(2).isEnabled = false

        floatingActionButton = findViewById(R.id.fab)
        floatingActionButton.setOnClickListener {
            Toast.makeText(this,"Fab Button Clicked", Toast.LENGTH_LONG).show()
        }
    }
}