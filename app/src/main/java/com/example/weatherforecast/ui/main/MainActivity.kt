package com.example.weatherforecast.ui.main

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.util.permissionHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val permission = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun onStart() {
        super.onStart()
        permissionHandler(
            permission,
            { navHostFragmentInit() },
            { finish() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun navHostFragmentInit() {
        val host = NavHostFragment.create(R.navigation.navigation)
        supportFragmentManager.commit {
            add(R.id.container, host)
            setPrimaryNavigationFragment(host)
        }
    }

}