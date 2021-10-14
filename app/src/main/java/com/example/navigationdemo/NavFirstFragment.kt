package com.example.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navigationdemo.databinding.FragmentNavFirstBinding
import timber.log.Timber


class NavFirstFragment : Fragment() {

    private lateinit var binding: FragmentNavFirstBinding

//    private val viewModel by navGraphViewModels<NavViewModel>(R.navigation.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel.exampleLiveData.observe(this) { value ->
//            binding.content.text = "$value"
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController = findNavController()
        binding.btn1.setOnClickListener {
            if (navController.currentDestination?.id == R.id.navFirstFragment) {
//                val args = NavFirstFragmentDirections
//                    .actionNavFirstFragmentToNavSecondFragment("参数一", 12)
//                navController.navigate(args)
                navController.navigate(R.id.action_navFirstFragment_to_navSecondFragment)
            } else if (navController.currentDestination?.id == R.id.navSecondFragment) {
                val args = NavSecondFragmentDirections.actionNavSecondFragmentSelf2("参数二", 20)
                navController.navigate(args)
            } else {
                Timber.d("当前啥也不是")
            }
        }

        binding.btn2.setOnClickListener {
            navController.navigate(R.id.action_navFirstFragment_to_navThirdFragment)
        }

        binding.btn3.setOnClickListener {
//            viewModel.exampleLiveData.value = 10
        }
    }
}