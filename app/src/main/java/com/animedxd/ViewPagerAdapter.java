package com.animedxd;
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
                return new SynopsisFragment();
            case 1:
                return new ReviewFragment();
            default:
                return new SynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // jumlah tab
    }
}
