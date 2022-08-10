package com.example.uas_akb_if1_10119013.ui.catatanharian;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_if1_10119013.R;
import com.example.uas_akb_if1_10119013.databinding.FragmentCatatanharianBinding;
import com.example.uas_akb_if1_10119013.model.catatanharian.CatatanHarianModel;
import com.example.uas_akb_if1_10119013.model.helper.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CatatanHarianFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton tambah_catatan;
    ImageView empty_image_view;
    TextView no_data;

    DatabaseHelper db;
    List<CatatanHarianModel> catatanHarianModelList;
    CatatanHarianAdapter catatanHarianAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catatanharian, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        tambah_catatan = view.findViewById(R.id.fab);
        empty_image_view = view.findViewById(R.id.empty_image_view);
        no_data = view.findViewById(R.id.no_data);

        tambah_catatan.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), AddCatatanHarianActivity.class);
            startActivity(intent);
        });

        db = new DatabaseHelper(getActivity());
        catatanHarianModelList = new ArrayList<>();

        storeDataInListModel();

        catatanHarianAdapter = new CatatanHarianAdapter(getActivity(), catatanHarianModelList);
        recyclerView.setAdapter(catatanHarianAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void storeDataInListModel(){
        Cursor cursor = db.getAllData();
        if(cursor.getCount() == 0){
            empty_image_view.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while(cursor.moveToNext()){

                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                System.out.println(cursor.getString(2));
                System.out.println(cursor.getString(3));
                System.out.println(cursor.getString(4));

                CatatanHarianModel catatanHarianModel = new CatatanHarianModel(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                catatanHarianModelList.add(catatanHarianModel);

            }
            empty_image_view.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}