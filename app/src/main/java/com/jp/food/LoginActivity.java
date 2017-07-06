package com.jp.food;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.idLoginEmailET) TextInputEditText loginEmailET;
    @BindView(R.id.idLoginPasswordET) TextInputEditText loginPassET;
    @BindView(R.id.idBtnLogin) Button btnLogin;
    @BindView(R.id.idTextForgotPass) TextView forgotPassTV;
    @BindView(R.id.idTextEnterReg) TextView enterRegTV;
    @BindView(R.id.idLoginPasswordLayout) TextInputLayout passwordLay;
    @BindView(R.id.idEmailLoginLayout) TextInputLayout emailLay;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(getString(R.string.login_title));
        ButterKnife.bind(this);
        Intent intent = getIntent();
        sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.pref_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (intent != null){
            final String emailReg = intent.getStringExtra(getString(R.string.email_key));
            final String passwordReg = intent.getStringExtra(getString(R.string.password_key));
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((loginEmailET.getText().toString().trim()== emailReg)&&
                            (loginPassET.getText().toString().toString()==passwordReg)){
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));

                    }
                }
            });

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idTextForgotPass:
                startActivity(new Intent(getApplicationContext(), ForgotActivity.class));
                break;
            case R.id.idTextEnterReg:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;


        }
    }
}
