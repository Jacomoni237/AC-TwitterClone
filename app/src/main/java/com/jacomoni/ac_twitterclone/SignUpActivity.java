package com.jacomoni.ac_twitterclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNext_in_Signup;
    private TextView edtName_in_Signup;
    private EditText edtPhone_email_in_Signup;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private Toolbar toolbarsignup;

    private  TextView edtDateOfBirth_in_Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

         // Initializing views
        txtNext_in_Signup = findViewById(R.id.txtNext_in_Signup);
         edtName_in_Signup = findViewById(R.id.edtName_in_Signup);
        edtPhone_email_in_Signup =findViewById(R.id.edtPhone_email_in_Signup);
        edtDateOfBirth_in_Signup =  findViewById(R.id.edtDateOfBirth_in_Signup);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        toolbarsignup = findViewById(R.id.toolbarsignup);





       // Set Onclick listener to the button next
        txtNext_in_Signup.setOnClickListener(this);
        toolbarsignup.setOnClickListener(this);



    }

      // Determining what will happen what will happen once the Next button is clicked.
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.txtNext_in_Signup:

                String edtBirthDate = "";
                String edtEmail="";
                String edtName = "";
                String edtPassword = "";


                final ParseUser newUser = new ParseUser();
                boolean allCorrect = true;
                try {

                    if (checkEmailValidation()) {
                         edtEmail = edtPhone_email_in_Signup.getText().toString();


                    } else {
                        Toast.makeText(SignUpActivity.this, " Email format not correct", Toast.LENGTH_LONG).show();
                        allCorrect = false;
                    }


                    if (!edtName_in_Signup.getText().toString().equals(null)) {
                         edtName = edtName_in_Signup.getText().toString();


                    } else {
                        Toast.makeText(SignUpActivity.this, " Name format not correct", Toast.LENGTH_LONG).show();
                        allCorrect = false;
                    }
               /**     if(!edtDateOfBirth_in_Signup.getText().toString().equals(null)) {

                            final Calendar calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            // Date picker diaglog

                            DatePickerDialog pickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    edtDateOfBirth_in_Signup.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                }
                            }, year, month, day);
                            pickerDialog.show();

                            edtBirthDate = edtDateOfBirth_in_Signup.getText().toString();
                        }  */

                    if (identicalPasswords() == true) {
                        edtPassword = edtConfirmPassword.getText().toString();


                    }
                    else {
                        Toast.makeText(SignUpActivity.this, " Passwords are not identical", Toast.LENGTH_LONG).show();
                        allCorrect = false;

                    }


                } catch (Exception e){
                    e.getMessage();
                }

                if (allCorrect == true){
                    Intent intent = new Intent(SignUpActivity.this, SignUpFinalActivity.class);

                    Bundle bundle = new Bundle();
                    intent.putExtra("username",edtName);
                    intent.putExtra("email",edtEmail);
                    intent.putExtra("birthDate", edtBirthDate);
                    intent.putExtra("password", edtPassword);


                    startActivity(intent);
                }

                break;

            case R.id.toolbarsignup: {
                Intent intent = new Intent(SignUpActivity.this, CreateAccountActivity.class);
                startActivity(intent);

            }break;

            default:
        }
    }

    private boolean checkEmailValidation()
    {

       String input = edtPhone_email_in_Signup.getText().toString();
        if(input.contains("@"))
        {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches();
        }
        else
        {
            return android.util.Patterns.PHONE.matcher(input).matches();
        }
    }



    // Confirming that both passwords entered are identical
    private boolean identicalPasswords(){

        boolean correct = false;

        if(edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString()))
            correct = true;

        return correct;
    }

    // Confirming the date format is correct.


}