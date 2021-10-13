package com.example.navigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        val navController = navHost?.findNavController()

        binding.btnLaunch.setOnClickListener {

            if (navController?.currentDestination?.id == R.id.navFirstFragment) {
                val args = NavFirstFragmentDirections
                    .actionNavFirstFragmentToNavSecondFragment("参数一", 12)
                navController.navigate(args)
            } else if (navController?.currentDestination?.id == R.id.navSecondFragment) {
                val args = NavSecondFragmentDirections.actionNavSecondFragmentSelf2("参数二", 20)
                navController.navigate(args)
            } else {
                Timber.d("当前啥也不是")
            }

        }
        binding.btnExit.setOnClickListener {
            navController?.navigate(R.id.navigation2)
//            navController?.navigate(R.id.navThirdFragment)
        }
    }
}