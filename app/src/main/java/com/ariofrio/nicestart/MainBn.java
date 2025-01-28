package com.ariofrio.nicestart;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ariofrio.nicestart.ui.main.SectionPagerAdapter;

public class MainBn extends AppCompatActivity {
    private SectionPagerAdapter sectionsPagerAdapter;
    private MenuItem prevMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bn);


        sectionsPagerAdapter = new SectionPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = binding.viewPager;
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);

        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.heart) {

                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();

                    viewPager1.setCurrentItem(0);
                    return true;
                }
                if (item.getItemId() == R.id.search) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();

                    viewPager1.setCurrentItem(1);
                    return true;
                }
                if (item.getItemId() == R.id.heart2) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();

                    viewPager1.setCurrentItem(2);
                    return true;
                }
                if (item.getItemId() == R.id.search2) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
                    viewPager1.setCurrentItem(3);
                    return true;
                }

                return false;
            }
        });

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mybottomNavView.getMenu().getItem(0).setChecked(false);
                    mybottomNavView.getMenu().getItem(position).setChecked(true);
                    //removeBadge(mybottomNavView, mybottomNavView.getMenu().getItem(position).getItemId());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });


    }

   /* public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }

    }*/


}

