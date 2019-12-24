package com.example.bottomnavigationexample.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.bottomnavigationexample.R
import com.example.bottomnavigationexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get( HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }


}