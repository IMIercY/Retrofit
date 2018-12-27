package kh.com.gbstech.testfeature.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Fragment.PostFragment;
import kh.com.gbstech.testfeature.Fragment.UserFragment;

public class AdapterViewPager extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();




    public AdapterViewPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        Log.d("fragment", "AdapterViewPager: "+fragments.size());
    }

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int i) {
//        Fragment fragment = new PostFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("s", "hello " + i);
//        fragment.setArguments(bundle);
//        return fragment;
        switch (i) {
            case 0:
                return new PostFragment();
            case 1:
                return new UserFragment();
            default:
                return new PostFragment();
        }
//        Log.d("fragment", "getItem: "+fragments.size());

    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "DataPost";
            case 1:
                return "DataUser";
            default:
                return "DataPost";
        }
    }
}
