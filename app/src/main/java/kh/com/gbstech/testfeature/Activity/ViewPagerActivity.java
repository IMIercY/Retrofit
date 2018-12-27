package kh.com.gbstech.testfeature.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Adapter.AdapterViewPager;
import kh.com.gbstech.testfeature.Fragment.PostFragment;
import kh.com.gbstech.testfeature.Fragment.UserFragment;
import kh.com.gbstech.testfeature.R;

public class ViewPagerActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager viewPager = findViewById(R.id.list_view_pager);
        PostFragment postFragment = new PostFragment();
        fragments.add(postFragment);
        UserFragment userFragment = new UserFragment();
        fragments.add(userFragment);

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterViewPager);

        TabLayout tabLayout = findViewById(R.id.tab_view_pager);
        tabLayout.setupWithViewPager(viewPager);


    }
}
