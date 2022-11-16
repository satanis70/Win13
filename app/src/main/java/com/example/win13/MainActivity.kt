package com.example.win13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.win13.databinding.ActivityMainBinding
import com.example.win13.databinding.FragmentMainBinding
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")

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