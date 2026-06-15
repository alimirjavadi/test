package com.example.testexam1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragmentA.newInstance("A");
            case 1:
                return FragmentA.newInstance("B");
            case 2:
                return FragmentA.newInstance("C");
            case 3:
                return FragmentA.newInstance("D");
            case 4:
                return FragmentA.newInstance("E");
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
