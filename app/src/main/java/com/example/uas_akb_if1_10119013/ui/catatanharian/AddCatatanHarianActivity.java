package com.example.uas_akb_if1_10119013.ui.catatanharian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_akb_if1_10119013.MenuActivity;
import com.example.uas_akb_if1_10119013.R;
import com.example.uas_akb_if1_10119013.model.catatanharian.CatatanHarianModel;
import com.example.uas_akb_if1_10119013.model.helper.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

//NIM   : 10119013
//NAMA  : FIONA AVILA PUTRI
//KELAS : IF-1

public class AddCatatanHarianActivity extends AppCompatActivity {
    EditText input_judul,input_kategori, input_isi;
    String input_tanggal;
    Button button_add, button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catatanharian);

        input_judul = findViewById(R.id.input_judul);
        input_kategori = findViewById(R.id.input_kategori);
        input_isi = findViewById(R.id.input_isi);
        input_tanggal = getDateNow(); //tanggal auto terisi ke database

        button_add = findViewById(R.id.button_add);
        button_back = findViewById(R.id.button_back);

        button_add.setOnClickListener(view -> {
            DatabaseHelper db = new DatabaseHelper(AddCatatanHarianActivity.this);
            CatatanHarianModel catatanHarianModel = new CatatanHarianModel("id",
                    input_judul.getText().toString().trim(),
                    input_kategori.getText().toString().trim(),
                    input_isi.getText().toString().trim(),
                    input_tanggal.trim());

            db.addCatatanHarian(catatanHarianModel);

            Intent intent = new Intent(AddCatatanHarianActivity.this, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddCatatanHarianActivity.this, CatatanHarianFragment.class);
                startActivity(i);
            }
        });
    }

    public String getDateNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}
