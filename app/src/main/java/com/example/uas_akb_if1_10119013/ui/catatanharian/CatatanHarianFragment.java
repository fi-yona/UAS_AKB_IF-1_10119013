package com.example.uas_akb_if1_10119013.ui.catatanharian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uas_akb_if1_10119013.databinding.FragmentCatatanharianBinding;

public class CatatanHarianFragment extends Fragment {

    private FragmentCatatanharianBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CatatanHarianViewModel catatanharianViewModel =
                new ViewModelProvider(this).get(CatatanHarianViewModel.class);

        binding = FragmentCatatanharianBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}