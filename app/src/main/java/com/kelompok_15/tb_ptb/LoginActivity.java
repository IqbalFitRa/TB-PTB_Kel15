package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Button login;
    //String userName = "Dosen";
    //String password = "dosen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login =(Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                TextView username = (TextView) findViewById(R.id.emailLogin);
                TextView password = (TextView) findViewById(R.id.passwordLogin);

                if(username.getText().toString().equals("Dosen") && password.getText().toString().equals("dosen")){
                    Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(login);
                }else
                    Toast.makeText(LoginActivity.this, "Email/Password Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}