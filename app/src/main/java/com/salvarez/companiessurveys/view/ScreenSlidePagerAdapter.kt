package com.salvarez.companiessurveys.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.salvarez.companiessurveys.view.fragment.ScreenSlidePagerFragment

private const val NUM_PAGES = 2

class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int =
        NUM_PAGES

    override fun createFragment(position: Int): Fragment =
        ScreenSlidePagerFragment.newInstance(
            position
        )
}