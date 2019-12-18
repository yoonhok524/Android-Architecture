package com.youknow.movie.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.youknow.movie.ui.nowplaying.NowPlayingFragment
import com.youknow.movie.ui.upcoming.UpcomingFragment

class BottomNavigationAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount() = 2

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> NowPlayingFragment()
        else -> UpcomingFragment()
    }

}