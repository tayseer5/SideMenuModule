package com.example.iti.sidemenumodule.daos;

import android.content.Context;
import android.util.Log;
import com.example.iti.sidemenumodule.model.Message;
import com.example.iti.sidemenumodule.model.Users;
import com.example.iti.sidemenumodule.network_manager.AfterAsynchronous;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;
import com.example.iti.sidemenumodule.network_manager.HttpClientConn;
import com.example.iti.sidemenumodule.network_manager.URLManager;
import com.loopj.android.http.RequestParams;


public class UserManager implements AfterAsynchronous {

    AfterPraseResult afterPraseResult;
    Context context;
    int code;
    public UserManager(Context context,AfterPraseResult afterPraseResult) {
        this.context = context;
        this.afterPraseResult=afterPraseResult;
    }

    public void Login(String email, String password) {
        HttpClientConn loginConnection = new HttpClientConn(this, context);
        RequestParams requestParam = new RequestParams();
        requestParam.add("email",email );
        requestParam.add("pass",password);
        loginConnection.RequestService(URLManager.loginURL, requestParam, 0, null, URLManager.postConnectionType);
    }

    public void registration(Users userData,int code) {
        this.code=code;
        HttpClientConn registrationConnection = new HttpClientConn(this, context);
        RequestParams requestParam = new RequestParams();
        requestParam.add("userEmail", userData.getUserEmail());
        requestParam.add("password", userData.getPassword());
        requestParam.add("gender", "");
        requestParam.add("userName", " ");
        requestParam.add("userImage", "");
        requestParam.add("0", "");
        requestParam.add("country", "");
        requestParam.add("governorate", "");
        requestParam.add("ciry", "");
        requestParam.add("street", "");
        requestParam.add("summery", "");
        requestParam.add("Title", "");
        requestParam.add("identifire", "");
        requestParam.add("mobiles", " , ");
        requestParam.add("phones", " , ");
        String skills = "";
        for (int i=0;i<userData.getUserSkills().size();i++)
        {
           skills= skills.concat(userData.getUserSkills().get(i).getSkillId()+",");
        }
        requestParam.add("skill", skills);
        registrationConnection.RequestService(URLManager.registrationURL, requestParam, 1, null, URLManager.postConnectionType);
    }

    public void logOut() {

    }

    public void updateUser(Users userNewData) {

    }

    public void uploadPhoto(Context context) {

        HttpClientConn loginConnection = new HttpClientConn(this, context);
        RequestParams requestParam = new RequestParams();
        requestParam.add("test", "test");
        loginConnection.RequestService(URLManager.imageURL, requestParam, 1, null, URLManager.postConnectionType);
    }

    @Override
    public void afterExecute(String response, int code) {

        switch (code) {
            case 0:
                //call login process
                Log.e("responce",response);

                break;
            case 1:
                //call registration process
                Log.e("responce",response);
                break;
            case 2:
                //call update process
                break;
            case 3:
                //test upload image

                break;
            default:
                break;
        }

    }

    @Override
    public void errorInExecute(String errorMessage) {
        switch (code) {
            case 0:
                //call login process
                break;
            case 1:
                //call registration process
                Log.e("errorMessage", errorMessage);
                break;
            case 2:
                //call update process
                break;
            case 3:
                //test upload image

                break;
            default:
                break;

        }
    }

}
