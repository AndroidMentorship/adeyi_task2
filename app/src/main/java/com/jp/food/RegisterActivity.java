package com.jp.food;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.idRegAddressET) TextInputEditText addressET;
    @BindView(R.id.idRegButton) Button regBtn;
    @BindView(R.id.idRegConfirmPassworET) TextInputEditText confirmPassET;
    @BindView(R.id.idRegPasswordET) TextInputEditText passwordET;
    @BindView(R.id.idRegPhoneET) TextInputEditText phoneET;
    @BindView(R.id.idRegNameET) TextInputEditText nameET;
    @BindView(R.id.idRegEmailET) TextInputEditText emailET;
    @BindView(R.id.idLayoutAddressET) TextInputLayout addressLayout;
    @BindView(R.id.idLayoutConfirmPassET) TextInputLayout confirmPasswordLayout;
    @BindView(R.id.idLayoutEmailET) TextInputLayout emailLayout;
    @BindView(R.id.idLayoutNameET) TextInputLayout nameLayout;
    @BindView(R.id.idLayoutPhoneET) TextInputLayout phoneLayout;
    @BindView(R.id.idLayoutPassword) TextInputLayout passwordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
     getSupportActionBar().setTitle(getString(R.string.registerTitle));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isKeysFiled()){
                    Toast.makeText(RegisterActivity.this, getString(R.string.registerCompleteMessage), Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra(getString(R.string.email_key),emailET.getText().toString().trim());
                    intent.putExtra(getString(R.string.password_key),passwordET.getText().toString().trim());
                    startActivity(intent);
                } else {
                    setErrors();
                }
            }
        });




    }

    public boolean isKeysFiled(){
        if (!addressET.getText().toString().trim().isEmpty()&&
                !confirmPassET.getText().toString().trim().isEmpty()&&
                !phoneET.getText().toString().trim().isEmpty() &&
                !nameET.getText().toString().trim().isEmpty() &&
                !emailET.getText().toString().trim().isEmpty() &&
                !passwordET.getText().toString().trim().isEmpty()&&
                ( passwordET.getText().toString().trim()== confirmPassET.getText().toString().trim())){
            return  true;
        } else {
            return false;
        }

    }

    public void setErrors(){
     if (addressET.getText().toString().trim().isEmpty()){
         addressLayout.setError(getString(R.string.error_field_required));
     }
        if (phoneET.getText().toString().trim().isEmpty()){
            phoneLayout.setError(getString(R.string.error_field_required));
        }
        if (nameET.getText().toString().trim().isEmpty()){
            nameLayout.setError(getString(R.string.error_field_required));
        }
        if (emailET.getText().toString().trim().isEmpty()){
            emailLayout.setError(getString(R.string.error_field_required));
        }
        if (confirmPassET.getText().toString().trim().isEmpty()){
            confirmPasswordLayout.setError(getString(R.string.error_field_required));
        }
        if (passwordET.getText().toString().trim().isEmpty()){
            passwordLayout.setError(getString(R.string.error_field_required));
        }
       if (passwordET.getText().toString().trim() != confirmPassET.getText().toString().trim()){
           confirmPasswordLayout.setError(getString(R.string.error_password_no_match));
       }

       if (!emailET.getText().toString().trim().matches("[a-zA-Z0-9.-]+\\.[a-z]")){
            emailLayout.setError(getString(R.string.error_invalid_email));
        }
    }

}
