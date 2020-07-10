package com.jacomoni.ac_twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView txtCreateAccount;
    private TextView txtLogin_in_CreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        txtCreateAccount = findViewById(R.id.txtCreateAccount);
        txtLogin_in_CreateAccount = findViewById(R.id.txtLogin_in_CreateAccount);

        txtCreateAccount.setOnClickListener(this);
        txtLogin_in_CreateAccount.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.txtCreateAccount:
                Intent intent = new Intent(CreateAccountActivity.this,SignUpActivity.class);
                CreateAccountActivity.this.startActivity(intent);
                break;

            case R.id.txtLogin_in_CreateAccount:
                intent = new Intent(CreateAccountActivity.this,LoginActivity.class);
                CreateAccountActivity.this.startActivity(intent);
                break;
            default:


        }

    }
}