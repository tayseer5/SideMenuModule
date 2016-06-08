package com.example.iti.sidemenumodule.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.daos.UserManager;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;

public class LoginFragment extends Fragment  implements AfterPraseResult{
    View rootView;
    EditText mail;
    EditText password;
    public LoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login_fragment, container, false);
        mail= (EditText) rootView.findViewById(R.id.loginEmail);
        password= (EditText) rootView.findViewById(R.id.loginPassword);
        Button loginButton = (Button) rootView.findViewById(R.id.login_bt);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginProcess();
            }
        });
        CheckBox showPasswordCheckBox = (CheckBox) rootView.findViewById(R.id.showPasswordCheckBox);
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(!isChecked)
                {
                    password.setInputType(129);
                }
                else
                {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

            }
        });
        return rootView;
    }

    private void LoginProcess() {
        UserManager userManager = new UserManager(this.getActivity(),this);
        userManager.Login(mail.getText().toString(),password.getText().toString());
//        SharedPreferences sharedpreferences = getActivity().getSharedPreferences("loginPrefrence", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//
//        if (mail.getText().toString().contentEquals("tayseer"))
//        {
//            Log.e("same", "userName");
//            editor.putString("mail", mail.getText().toString());
//            editor.commit();
//        }
//        if (password.getText().toString().contentEquals("123"))
//        {
//            Log.e("same","password");
//            String isLogin = sharedpreferences.getString("mail","Not login");
//            Log.e("is register",isLogin);
//        }
    }

    @Override
    public void afterParesResult(Object message, int code) {
        Log.e("msg",message.toString());
    }

    @Override
    public void errorParesResult(String errorMessage, int code) {
        Log.e("errorMessage",errorMessage.toString());

    }
}
