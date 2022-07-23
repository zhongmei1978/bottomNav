package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    BottomNavigationView bNavView;

    List<Fragment> fragList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.vp);
        bNavView = findViewById(R.id.nav);

        initData();

        ContentPagerAdapter adapter = new ContentPagerAdapter(this,fragList);
        viewPager.setAdapter(adapter);

         viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                 super.onPageScrolled(position, positionOffset, positionOffsetPixels);
             }

             @Override
             public void onPageSelected(int position) {
                 super.onPageSelected(position);

                 bNavView.getMenu().getItem(position).setChecked(true);
             }

             @Override
             public void onPageScrollStateChanged(int state) {
                 super.onPageScrollStateChanged(state);
             }
         });


        bNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_share:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.item_collect:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.item_edit:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.item_delete:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                return true;
            }
        });

    }

    private void initData() {
        fragList.add(new SharedFragment());
        fragList.add(new CollectFragment());
        fragList.add(new editFragment());
        fragList.add(new delFragment());

    }
}