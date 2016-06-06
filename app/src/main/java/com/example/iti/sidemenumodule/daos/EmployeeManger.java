package com.example.iti.sidemenumodule.daos;

import android.content.Context;
import android.util.Log;

import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Employee;
import com.example.iti.sidemenumodule.model.Users;
import com.example.iti.sidemenumodule.network_manager.AfterAsynchronous;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;
import com.example.iti.sidemenumodule.network_manager.HttpClientConn;
import com.example.iti.sidemenumodule.network_manager.URLManager;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 6/6/2016.
 */
public class EmployeeManger implements AfterAsynchronous{
    private static ArrayList<Users> employeesList;
    private static EmployeeManger employeeManger;
    private AfterPraseResult view;
    private static Context context;
    public  static EmployeeManger getInstance(Context c){
        if(employeeManger==null)
        {
            context=c;
            employeeManger=new EmployeeManger();
        }
        return employeeManger;
    }

    public void getEmployeesList(AfterPraseResult view){
        this.view=view;
        if(employeesList==null){
            String employeeURL= URLManager.getEmployeesURL;
            HttpClientConn loginConnection = new HttpClientConn(this, context);
            RequestParams requestParam = new RequestParams();
            loginConnection.RequestService(employeeURL, requestParam, 1, null, 1);
        }else {
            this.view.afterParesResult(employeesList);
        }
    }

    @Override
    public void afterExecute(String message, int code) {
        if (code==1){
            try {
                JSONObject object=new JSONObject(message);
                String myData =object.getString("users");
                JSONArray jsonArray=new JSONArray(myData);
                employeesList=new ArrayList<>();
                for (int i=0;i<jsonArray.length();i++) {
                    Gson gson = new Gson();
                    String element=jsonArray.getString(i);
                    Users emoloyee = gson.fromJson(element, Users.class);
                    Log.i("gsontest", emoloyee.getUserName());
                    employeesList.add(emoloyee);
                }
                view.afterParesResult(employeesList);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void errorInExecute(String errorMessage) {
        view.errorParesResult("");
    }
}
