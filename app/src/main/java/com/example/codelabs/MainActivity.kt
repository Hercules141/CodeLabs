package com.example.codelabs

import android.annotation.SuppressLint
import android.app.TaskStackBuilder
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.codelabs.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(){
    lateinit var binding :ActivityMainBinding
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()

        binding.navButton.setOnClickListener(){
            it.setBackgroundColor(Color.GREEN)
//            navController.navigate(R.id.ANewWorld)
            navController.navigate(R.id.action_startFragment_to_ANewWorld)

        }

    }

    override fun onStart() {
        super.onStart()
        navController = navHostFragment.navController
    }
}