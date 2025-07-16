package com.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final int animeId;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, int animeId) {
        super(fragmentActivity);
        this.animeId = animeId;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return SynopsisFragment.newInstance(animeId); // Kirim animeId ke Synopsis
        } else if (position == 1) {
            return ReviewFragment.newInstance(animeId);   // ✅ Kirim animeId ke ReviewFragment
        }
        return new Fragment(); // default
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
