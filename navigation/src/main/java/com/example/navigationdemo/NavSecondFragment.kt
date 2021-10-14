package com.example.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.example.navigationdemo.databinding.FragmentNavSecondBinding


class NavSecondFragment : Fragment() {
    private lateinit var binding: FragmentNavSecondBinding
    private var param1: String? = null
    private var param2: Int? = null

    private val args by navArgs<NavSecondFragmentArgs>()

//    private val viewModel by navGraphViewModels<NavViewModel>(R.navigation.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        param1 = args.p1
        param2 = args.p2
        Toast.makeText(requireContext(), "$param1-$param2", Toast.LENGTH_SHORT).show()

//        viewModel.exampleLiveData.observe(this) { value ->
//            binding.content.text = "$value"
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btn1.setOnClickListener {
//            viewModel.exampleLiveData.value = 20
        }
    }
}