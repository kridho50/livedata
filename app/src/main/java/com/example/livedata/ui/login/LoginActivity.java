package com.example.livedata.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.livedata.MainActivity;
import com.example.livedata.R;
import com.example.livedata.ui.home.HomeViewModel;
import com.example.livedata.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button buttonLogin, buttonRegis;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.btLogin);
        buttonRegis = findViewById(R.id.btregis);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.onLogin(username.getText().toString(),password.getText().toString());
            }
        });

        buttonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        sukses();

    }

    public void sukses(){
        loginViewModel.loginResult().observe(LoginActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("success")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if(s.equals("failure")) {
                    Toast.makeText(LoginActivity.this,"Upss Ada yang salah",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}