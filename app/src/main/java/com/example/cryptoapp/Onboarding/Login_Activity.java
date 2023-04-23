package com.example.cryptoapp.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cryptoapp.HomePage_Activity;
import com.example.cryptoapp.R;

public class Login_Activity extends AppCompatActivity {

    private EditText editTxt_userName, editTxt_password;
    private TextView txtView_forgetPassword, txtView_registerNow;
    private androidx.appcompat.widget.AppCompatButton btn_login;

    //Variables to store values
    private String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = editTxt_userName.getText().toString();
                password = editTxt_password.getText().toString();

                //TODO: Once a backend is added, cross check then and change the code

                validateUserName();
                validatePassword();
                validateInput();
            }
        });
    }

    private void validateInput() {
        if (!validateUserName() | !validatePassword())
            return;
        else
            startActivity(new Intent(getApplicationContext(), HomePage_Activity.class));
    }

    private boolean validatePassword() {
        if (password.isEmpty())
        {
            editTxt_password.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else
            return true;
    }

    private boolean validateUserName() {
        if (userName.isEmpty())
        {
            editTxt_userName.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else
        return true;
    }

    private void initWidget() {
        //EditText
        editTxt_userName = findViewById(R.id.editTxt_userName);
        editTxt_password = findViewById(R.id.editTxt_password);

        //TextView
        txtView_forgetPassword = findViewById(R.id.txtView_forgetPassword);
        txtView_registerNow = findViewById(R.id.txtView_registerNow);

        //Button
        btn_login = findViewById(R.id.btn_login);

    }
}