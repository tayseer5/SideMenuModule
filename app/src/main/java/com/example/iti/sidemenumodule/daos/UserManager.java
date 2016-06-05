package com.example.iti.sidemenumodule.daos;

import android.content.Context;

import com.example.iti.sidemenumodule.model.Message;
import com.example.iti.sidemenumodule.model.Users;
import com.example.iti.sidemenumodule.network_manager.AfterAsynchronous;
import com.example.iti.sidemenumodule.network_manager.HttpClientConn;
import com.example.iti.sidemenumodule.network_manager.URLManager;
import com.loopj.android.http.RequestParams;

/**
 * Created by ITI on 03/06/2016.
 */
public class UserManager implements AfterAsynchronous {



    public UserManager() {
    }

    public void Login(String userName,String password, Context context)
    {
        String url="";
        HttpClientConn loginConnection = new HttpClientConn(this, context);
        RequestParams requestParam = new RequestParams();
        requestParam.add("test","test");
        loginConnection.RequestService(url,requestParam,1,null,0);
    }
    public void registration(Users userData) {

    }
    public void logOut(){

    }
    public void updateUser(Users userNewData)
    {

    }
    public void uploadPhoto(Context context)
    {

        HttpClientConn loginConnection = new HttpClientConn(this, context);
        RequestParams requestParam = new RequestParams();
        requestParam.add("test","test");
        loginConnection.RequestService(URLManager.imageURL,requestParam,1,null,0);
    }
    @Override
    public void afterExecute(Message message, int code) {
        switch (code)
        {
            case 0:
                //call login process
                break;
            case 1:
                //call registration process
                break;
            case 2:
                //call update process
                break;
            case 3:
                //test upload image
                UploadPhotoProcess(message);
                break;
            default:
                break;
        }

    }

    @Override
    public void errorInExecute(String errorMessage) {

    }

    private void UploadPhotoProcess(Message message)
    {

    }
}
