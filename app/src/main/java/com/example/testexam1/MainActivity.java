package com.example.testexam1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(viewPagerAdapter);
    }
}