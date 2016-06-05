package com.example.iti.sidemenumodule.view;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.iti.sidemenumodule.R;

/**
 * Created by ITI on 20/05/2016.
 */
public class RegistrationTabView extends Fragment implements View.OnClickListener {
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.login_registration_tab_view, container, false);
        Button bt = (Button) rootView.findViewById(R.id.button);
        bt.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View view) {
       EditText userName= (EditText) rootView.findViewById(R.id.editText);
        EditText password= (EditText) rootView.findViewById(R.id.editText2);
        SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences("loginPrefrence", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        if (userName.getText().toString().contentEquals("tayseer"))
        {
            Log.e("same","userName");
            editor.putString("userName", userName.getText().toString());
            editor.commit();
        }
        if (password.getText().toString().contentEquals("123"))
        {
            Log.e("same","password");
            String isLogin = sharedpreferences.getString("userName","Not login");
            Log.e("is register",isLogin);
//            Intent intent = new Intent(getActivity(),ActicityWithSideMenu.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
        }
    }
}
