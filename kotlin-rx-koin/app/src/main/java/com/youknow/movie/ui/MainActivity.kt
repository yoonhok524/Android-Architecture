package com.youknow.movie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.youknow.movie.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

const val MOVIE_ID = "movie_id"

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewPager.adapter = BottomNavigationAdapter(supportFragmentManager)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_now_playing -> {
                    info("[Movies] onNavigationItemSelected - selected: now playing")
                    mainViewPager.currentItem = 0
                    true
                }
                R.id.action_upcoming -> {
                    info("[Movies] onNavigationItemSelected - selected: upcoming")
                    mainViewPager.currentItem = 1
                    true
                }
                else -> false
            }
        }

        mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                info("[Movies] onPageSelected - $position")
                (bottomNavigation as BottomNavigationView).menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
}