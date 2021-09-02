package com.example.livedata.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.livedata.MainActivity;
import com.example.livedata.R;
import com.example.livedata.ui.login.LoginActivity;
import com.example.livedata.ui.login.LoginViewModel;

public class RegisterActivity extends AppCompatActivity {

    EditText username, name, password;
    Button button;
    private RegisterViewModel registerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerViewModel =
                ViewModelProviders.of(this).get(RegisterViewModel.class);
        username = findViewById(R.id.et_username);
        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        button = findViewById(R.id.bt_register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerViewModel.register(username.getText().toString(),
                        name.getText().toString(),password.getText().toString());
            }
        });
        sukses();
        registerViewModel.failUsername().observe(RegisterActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.equals("username")) {
                    Toast.makeText(RegisterActivity.this,"username kosong",Toast.LENGTH_LONG).show();
                } else if (s.equals("password")) {
                    Toast.makeText(RegisterActivity.this,"password kosong",Toast.LENGTH_LONG).show();
                } else if (s.equals("name")) {
                    Toast.makeText(RegisterActivity.this,"name kosong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void sukses(){
        registerViewModel.registerResult().observe(RegisterActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
               if(s.equals("success")) {
                   Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                   startActivity(intent);
               } else if (s.equals("failure")) {
                   Toast.makeText(RegisterActivity.this,"ups gagal",Toast.LENGTH_LONG).show();
               }
            }
        });

    }
}