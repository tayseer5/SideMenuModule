package com.example.iti.sidemenumodule.view;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.daos.SkillsManager;
import com.example.iti.sidemenumodule.daos.UserManager;
import com.example.iti.sidemenumodule.helperclasses.DialogResponce;
import com.example.iti.sidemenumodule.model.Skills;
import com.example.iti.sidemenumodule.model.Users;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;


public class SignUpFragment extends Fragment implements DialogResponce, View.OnClickListener,AfterPraseResult {
    View rootView;
    ArrayList<Skills> selectedList;
    EditText email;
    EditText password;
    EditText rePassword;
    CheckBox ruleAgree;
    public SignUpFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.signup_fragment, container, false);
        email= (EditText) rootView.findViewById(R.id.signUpEmail);
        password = (EditText) rootView.findViewById(R.id.signUpPassword);
        rePassword = (EditText) rootView.findViewById(R.id.signUpRePassword);
        ruleAgree = (CheckBox) rootView.findViewById(R.id.ruleAgreecheckBox);

        Button skillsButton = (Button) rootView.findViewById(R.id.choiseSkills);
        skillsButton.setOnClickListener(this);
        Button sighupButton = (Button) rootView.findViewById(R.id.sigin_up_button);
        sighupButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void result(ArrayList<Skills> selectedList) {
        this.selectedList=selectedList;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.choiseSkills:
                getSkills();
                break;
            case R.id.sigin_up_button:
                signUpInformationCollection();
                break;
        }


    }

    private void signUpInformationCollection() {
      if(ruleAgree.isChecked())
      {
          if (password.getText().toString().trim().equals(rePassword.getText().toString()))
          {
              Users users = new Users();
             if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
                 users.setUserEmail(email.getText().toString().trim());
                 users.setPassword(password.getText().toString().trim());
                 if (!selectedList.isEmpty())
                 {
                     users.setUserSkills(selectedList);
                     signUpProcess(users);
                 }
                 else
                 {
                     //alert select skills
                 }
             }

          }
          else
          {
              //alert passwords identical
          }

      }
        else
      {
          //alert agree terms
      }
    }

    private void signUpProcess(Users users) {
        UserManager userManager = new UserManager(this.getActivity(),this);
        userManager.registration(users,1);
    }

    private void getSkills() {
        SkillsManager skillsManager = new SkillsManager(this.getActivity(),this);
        skillsManager.getSkills(1);
    }

    @Override
    public void afterParesResult(Object message, int code) {
        Log.e("reach fragmnet seccuss",message.toString());
        showSkillsDialog((ArrayList<Skills>) message);
    }

    @Override
    public void errorParesResult(String errorMessage, int code) {
        Log.e("reach fragmnet fail",errorMessage.toString());
    }
    private void showSkillsDialog(ArrayList<Skills> allSkills)
    {
        Gson gson = new Gson();
        String allSkillsJsonArray =gson.toJson(allSkills);
        Skills_Alert_Dialog_fragment dialogFragment = new Skills_Alert_Dialog_fragment();
        Bundle args = new Bundle();
        args.putString("skills", allSkillsJsonArray);
        dialogFragment.setArguments(args);
        dialogFragment.setTargetFragment(this,0);
        dialogFragment.show(getFragmentManager(), "skills");

    }


}
