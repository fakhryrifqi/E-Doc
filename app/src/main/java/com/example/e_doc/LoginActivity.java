package com.example.e_doc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_doc.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);


        loginViewModel = new ViewModelProvider(LoginActivity.this).get(LoginViewModel.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUsername = etUsername.getText().toString();
                String mPassword = etPassword.getText().toString();

                if (!mUsername.isEmpty() || !mPassword.isEmpty()){
                    loginViewModel.login(mUsername, mPassword);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Harap cek kembali username dan password anda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}