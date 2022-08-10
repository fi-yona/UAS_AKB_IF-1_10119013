package com.example.uas_akb_if1_10119013;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText input_email, input_password;
    private Button button_back_login, button_register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar ab = getSupportActionBar();
        if (ab != null)  ab.setTitle("Daftar Akun");

        auth = FirebaseAuth.getInstance();

        input_email = (EditText) findViewById(R.id.regEmail);
        input_password = (EditText) findViewById(R.id.regPassword);
        button_back_login = (Button) findViewById(R.id.back_login);
        button_register = (Button) findViewById(R.id.regUser);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = input_email.getText().toString().trim();
                String password = input_password.getText().toString().trim();
                if (email.isEmpty()) input_email.setError("Email tidak boleh kosong");
                else if (password.isEmpty()) input_password.setError("Password tidak boleh kosong");
                else if (password.length() < 6) input_password.setError("Password harus lebih dari 6 karakter");
                else {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
            }
        });

        button_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }
}
