package com.jacomoni.ac_twitterclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtSignUp_in_LoginToolbar;
    private EditText edtUsername_in_Login;
    private EditText edtPassword_in_Login;
    private TextView txtForgottenPassword;
    private TextView txtLogin_in_Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbarlogin);
        setSupportActionBar(toolbar);

        txtSignUp_in_LoginToolbar = findViewById(R.id.txtSignUp_in_LoginToolbar);
        edtUsername_in_Login = findViewById(R.id.edtUsername_in_Login);
        edtPassword_in_Login = findViewById(R.id.edtPassword_in_Login);
        txtForgottenPassword = findViewById(R.id.txtForgottenPassword);
        txtLogin_in_Signup = findViewById(R.id.txtLogin_in_Signup);

        txtSignUp_in_LoginToolbar.setOnClickListener(this);
        txtLogin_in_Signup.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_in_login, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
                 Intent intent;
        switch (view.getId()){

            case R.id.txtSignUp_in_LoginToolbar:
                 intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.txtLogin_in_Signup:
                intent = new Intent(LoginActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;


            default:
        }
    }
}