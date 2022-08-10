package com.example.uas_akb_if1_10119013.ui.catatanharian;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
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

public class UpdateCatatanHarianActivity extends AppCompatActivity {

    EditText input_judul_update,input_kategori_update, input_isi_update;
    Button button_update, button_delete, button_back;
    String input_tanggal;
    CatatanHarianModel catatanHarianModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_catatanharian);

        input_judul_update = findViewById(R.id.input_judul_update);
        input_kategori_update = findViewById(R.id.input_kategori_update);
        input_isi_update = findViewById(R.id.input_isi_update);
        input_tanggal = getDateNow();
        button_update = findViewById(R.id.button_update);
        button_delete = findViewById(R.id.button_delete);
        button_back = findViewById(R.id.button_back);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(catatanHarianModel.getJudul());
        }

        button_update.setOnClickListener(view -> {
            DatabaseHelper db =new DatabaseHelper(UpdateCatatanHarianActivity.this);
            catatanHarianModel = new CatatanHarianModel(
                    catatanHarianModel.getId(),
                    input_judul_update.getText().toString().trim(),
                    input_kategori_update.getText().toString().trim(),
                    input_isi_update.getText().toString().trim(),
                    input_tanggal.trim()
            );

            db.updateCatatanHarian(catatanHarianModel);

            Intent intent = new Intent(UpdateCatatanHarianActivity.this, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateCatatanHarianActivity.this, CatatanHarianFragment.class);
                startActivity(i);
            }
        });
    }

    public String getDateNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id")
                && getIntent().hasExtra("judul")
                && getIntent().hasExtra("kategori")
                && getIntent().hasExtra("isi")
                && getIntent().hasExtra("tanggal")) {

            catatanHarianModel = new CatatanHarianModel(
                    getIntent().getStringExtra("id"),
                    getIntent().getStringExtra("judul"),
                    getIntent().getStringExtra("kategori"),
                    getIntent().getStringExtra("isi"),
                    getIntent().getStringExtra("tanggal")
            );

            input_judul_update.setText(catatanHarianModel.getJudul());
            input_kategori_update.setText(catatanHarianModel.getKategori());
            input_isi_update.setText(catatanHarianModel.getIsi());

            Log.d("stev", catatanHarianModel.getJudul() + " " + catatanHarianModel.getKategori() + " " + catatanHarianModel.getIsi());
        }else{
            Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + catatanHarianModel.getJudul() + " ?");
        builder.setMessage("Yakin ingin menghapus catatan " + catatanHarianModel.getJudul() + " ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper db = new DatabaseHelper(UpdateCatatanHarianActivity.this);
                db.delete(String.valueOf(catatanHarianModel.getId()));
                finish();

                Intent intent = new Intent(UpdateCatatanHarianActivity.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}