package com.youknow.movie.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.youknow.movie.ui.nowplaying.NowPlayingFragment;
import com.youknow.movie.ui.upcoming.UpcomingFragment;

public class BottomNavigationAdapter extends FragmentStatePagerAdapter {

    BottomNavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NowPlayingFragment();
            default:
                return new UpcomingFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
