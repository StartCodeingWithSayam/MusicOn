package com.flexstudio.musicon.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flexstudio.musicon.fragments.FavoriteFragment
import com.flexstudio.musicon.fragments.HomeMainFragment
import com.flexstudio.musicon.fragments.PlaylistFragment

class HomePagerAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> HomeMainFragment()
           1 -> PlaylistFragment()
           else -> FavoriteFragment()
       }
    }
}