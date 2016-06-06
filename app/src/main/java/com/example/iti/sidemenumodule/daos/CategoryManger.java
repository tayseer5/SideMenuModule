package com.example.iti.sidemenumodule.daos;

import android.content.Context;
import android.util.Log;

import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Message;
import com.example.iti.sidemenumodule.network_manager.AfterAsynchronous;
import com.example.iti.sidemenumodule.network_manager.HttpClientConn;
import com.example.iti.sidemenumodule.network_manager.URLManager;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 6/5/2016.
 */
public class CategoryManger implements AfterAsynchronous{
    private static ArrayList<Category> categoriesList;
    private static CategoryManger categoryManger;
    private static Context context;
    public  static CategoryManger getInstance(Context c){
        if(categoryManger==null)
        {
            context=c;
         categoryManger=new CategoryManger();
        }
            return categoryManger;
    }

    public ArrayList<Category> getCategoriesList(){
        if(categoriesList==null){
            String categoryURL= URLManager.getCategoryURL;
            HttpClientConn loginConnection = new HttpClientConn(this, context);
            RequestParams requestParam = new RequestParams();
            loginConnection.RequestService(categoryURL, requestParam, 1, null, 1);
            categoriesList=new ArrayList<>();
        }
        return categoriesList;
    }

    @Override
    public void afterExecute(String message, int code) {
        if (code==1){
            try {
                JSONObject object=new JSONObject(message);
                String myData =object.getString("categories");
                JSONArray jsonArray=new JSONArray(myData);
                categoriesList=new ArrayList<>();
                for (int i=0;i<jsonArray.length();i++) {
                    Gson gson = new Gson();
                    String element=jsonArray.getString(i);
                    Category category = gson.fromJson(element, Category.class);
                    Log.i("gsontest",category.getCategoryName());
                    categoriesList.add(category);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void errorInExecute(String errorMessage) {

    }
}
