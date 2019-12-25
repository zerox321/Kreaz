package com.example.bottomnavigationexample.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationexample.R
import com.example.bottomnavigationexample.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {


    private val viewModel: NotificationsViewModel by lazy {
        ViewModelProviders.of(this).get( NotificationsViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNotificationsBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }


}