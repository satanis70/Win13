package com.example.win13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.win13.databinding.ActivityMainBinding
import com.example.win13.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frame_layout_container) as NavHostFragment
        val navController = navHostFragment.navController
        val bar = mainBinding.bottomBar
        bar.setItemSelected(R.id.team)
        bar.setOnItemSelectedListener {
            when (it) {
                R.id.team -> {
                    navController.navigate(R.id.mainFragment)
                }
                R.id.tips -> {
                    navController.navigate(R.id.tipsFragment)
                }
                R.id.vocabulary -> {
                    navController.navigate(R.id.vocabularyFragment)
                }
            }
        }
    }
}