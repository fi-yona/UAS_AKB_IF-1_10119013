package com.example.uas_akb_if1_10119013;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//NIM   : 10119013
//NAMA  : FIONA AVILA PUTRI
//KELAS : IF1

public class SplashScreenActivity extends AppCompatActivity {

    private Button button_mulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        button_mulai = findViewById(R.id.rectangle_button_mulai);

        button_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}