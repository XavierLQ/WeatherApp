package com.example.myweatherappcat22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myweatherappcat22.adapter.ClickedWeather
import com.example.myweatherappcat22.databinding.ActivityMainBinding
import com.example.myweatherappcat22.model.Main
import com.example.myweatherappcat22.views.ForecastDetailsFragment


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.frag_nav_container)
        appBarConfiguration = AppBarConfiguration(navController.graph)

       setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.frag_nav_container)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}


