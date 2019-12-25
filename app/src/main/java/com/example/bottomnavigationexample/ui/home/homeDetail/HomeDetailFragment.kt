package com.example.bottomnavigationexample.ui.home.homeDetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.example.bottomnavigationexample.databinding.HomeDetailFragmentBinding
import com.example.bottomnavigationexample.ui.home.CategoryData

class HomeDetailFragment : Fragment() {


    private val args: HomeDetailFragmentArgs by navArgs()

    private val viewModel: HomeDetailViewModel by lazy {
        ViewModelProviders.of(this).get(HomeDetailViewModel::class.java)
    }

    private val category: CategoryData by lazy {
        args.category
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = HomeDetailFragmentBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this

        binding.category = category

        binding.viewModel = viewModel

        return binding.root
    }


}
