package com.jacomoni.ac_twitterclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpFinalActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPersonName;
    private EditText edtPhoneNumber;
    private EditText edtDateOfBirth;
    private TextView txtSignUp_in_Final;
    private Toolbar toolbarsignup;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_final);

        edtPersonName = findViewById(R.id.edtPersonName);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtDateOfBirth = findViewById(R.id.edtDateOfBirth);
        txtSignUp_in_Final = findViewById(R.id.txtSignUp_in_Final);
        toolbarsignup = findViewById(R.id.toolbarsignup);

      Bundle bundle = getIntent().getExtras();
      String name = bundle.getString("username");
      String email = bundle.getString("email");
      String birthDay = bundle.getString("birthDay");
      password = bundle.getString("password");

      edtPersonName.setText(name);
      edtPhoneNumber.setText(email);
      edtDateOfBirth.setText(birthDay);

      txtSignUp_in_Final.setOnClickListener(this);
      toolbarsignup.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        final ParseUser newUser = new ParseUser();


        switch (view.getId()){

            case R.id.toolbarsignup: {
                Intent intent = new Intent(SignUpFinalActivity.this, SignUpActivity.class);
                startActivity(intent);

            }break;

            case R.id.txtSignUp_in_Final:{
                Intent intent = new Intent(SignUpFinalActivity.this, LoginActivity.class);

                newUser.setUsername(edtPersonName.getText().toString());
                newUser.setEmail(edtPhoneNumber.getText().toString());
                newUser.setPassword(password);

                newUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            alertDisplayer("Successful Sign Up!", "Welcome " + edtPersonName.getText().toString() + "!");

                        } else {
                            ParseUser.logOut();
                           // Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

                startActivity(intent);



            }break;
        }

    }


    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpFinalActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        // don't forget to change the line below with the names of your Activities
                        Intent intent = new Intent(SignUpFinalActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}