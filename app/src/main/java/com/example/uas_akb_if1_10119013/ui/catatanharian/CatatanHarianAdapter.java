package com.example.uas_akb_if1_10119013.ui.catatanharian;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_if1_10119013.R;
import com.example.uas_akb_if1_10119013.model.catatanharian.CatatanHarianModel;

import java.util.List;

//NIM   : 10119013
//NAMA  : FIONA AVILA PUTRI
//KELAS : IF-1

public class CatatanHarianAdapter extends RecyclerView.Adapter<CatatanHarianAdapter.CatatanHarianViewHolder> {

    private Activity activity;
    private List<CatatanHarianModel> catatanHarianModelList;

    CatatanHarianAdapter(Activity activity, List<CatatanHarianModel> catatanHarianModelList){
        this.activity = activity;
        this.catatanHarianModelList = catatanHarianModelList;
    }

    @NonNull
    @Override
    public CatatanHarianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new CatatanHarianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanHarianViewHolder holder, int position) {
        holder.judul.setText(String.valueOf(catatanHarianModelList.get(position).getJudul()));
        holder.kategori.setText(String.valueOf(catatanHarianModelList.get(position).getKategori()));
        holder.tanggal.setText(String.valueOf(catatanHarianModelList.get(position).getTanggal()).substring(0,10));
        holder.isi.setText(String.valueOf(catatanHarianModelList.get(position).getIsi()));

        holder.list_catatan_harian.setOnClickListener(view -> {
            Intent intent = new Intent(activity, UpdateCatatanHarianActivity.class);
            intent.putExtra("id", String.valueOf(catatanHarianModelList.get(position).getId()));
            intent.putExtra("judul", String.valueOf(catatanHarianModelList.get(position).getJudul()));
            intent.putExtra("kategori", String.valueOf(catatanHarianModelList.get(position).getKategori()));
            intent.putExtra("isi", String.valueOf(catatanHarianModelList.get(position).getIsi()));
            intent.putExtra("tanggal", String.valueOf(catatanHarianModelList.get(position).getTanggal()));
            activity.startActivityForResult(intent, 1);
        });

    }

    @Override
    public int getItemCount() {
        if(catatanHarianModelList != null) return catatanHarianModelList.size();
        return 0;
    }

    public class CatatanHarianViewHolder extends RecyclerView.ViewHolder{
        TextView judul, kategori, tanggal, isi;
        LinearLayout list_catatan_harian;

        CatatanHarianViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.label_judul);
            kategori = itemView.findViewById(R.id.label_kategori);
            tanggal = itemView.findViewById(R.id.label_tanggal);
            isi = itemView.findViewById(R.id.label_isi);
            list_catatan_harian = itemView.findViewById(R.id.list_catatan_harian);
        }
    }
}