package com.flexstudio.musicon.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.flexstudio.musicon.R
import com.flexstudio.musicon.adapters.HomePagerAdapter
import com.flexstudio.musicon.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val tabTitles = arrayListOf("All" , "Today" , "Week" , "Month")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupLayoutWithViewPager()
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
    }

    private fun addListeners(){
        binding.btnSetting.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

    }


    private fun setupLayoutWithViewPager() {
        binding.viewPager2.adapter = HomePagerAdapter(this)
        TabLayoutMediator(binding.tabBarLayout , binding.viewPager2){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}