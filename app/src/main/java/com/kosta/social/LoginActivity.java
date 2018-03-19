package com.kosta.social;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edt_email)
    EditText mEmail;
    @BindView(R.id.edt_password)
    EditText mPassword;
    @BindView(R.id.btn_login)
    TextView mLogin;
    @BindView(R.id.btn_register)
    TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked(){


    }

    @OnClick(R.id.btn_register)
    public void onRegisterClicked(){


    }
}
