package com.example.uas_akb_if1_10119013.ui.informasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.uas_akb_if1_10119013.R;
import com.example.uas_akb_if1_10119013.databinding.FragmentInformasiBinding;
import com.google.android.material.tabs.TabLayout;

public class InformasiFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @NonNull
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informasi, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_informasi);
        viewPager = view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        InformasiViewPagerAdapter infoViewPagerAdapter = new InformasiViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        infoViewPagerAdapter.addFragment(new TentangViewPagerFragment(), "Tentang");
        infoViewPagerAdapter.addFragment(new VersiViewPagerFragment(), "Versi");
        infoViewPagerAdapter.addFragment(new MadeByViewPagerFragment(), "Made by");
        viewPager.setAdapter(infoViewPagerAdapter);

        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}