package com.example.iti.sidemenumodule.daos;

import android.content.Context;
import android.util.Log;

import com.example.iti.sidemenumodule.model.Skills;
import com.example.iti.sidemenumodule.network_manager.AfterAsynchronous;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;
import com.example.iti.sidemenumodule.network_manager.HttpClientConn;
import com.example.iti.sidemenumodule.network_manager.URLManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITI on 07/06/2016.
 */
public class SkillsManager implements AfterAsynchronous {

    static Skills skills;
    Context context;
    AfterPraseResult afterPraseResult;
    int code;

    public SkillsManager(Context context,AfterPraseResult afterPraseResult) {
        skills = new Skills();
        this.context = context;
        this.afterPraseResult=afterPraseResult;
    }

    public void getSkills(int code) {
        this.code=code;
        HttpClientConn getSkillsConnection = new HttpClientConn(this, context);
        getSkillsConnection.RequestService(URLManager.skillsURl, null, 1, null, URLManager.getConnectionType);
    }

    @Override
    public void afterExecute(String response, int code) {
        if (code == 1) {
            getSkillsProcess(response,URLManager.success);
        }


    }

    @Override
    public void errorInExecute(String errorMessage) {
        Log.e("Error msg from manager",errorMessage);
        getSkillsProcess("Erro in connection please try again later", URLManager.fail);

    }
    private void getSkillsProcess(String response, int code)
    {
        switch (code) {
            case URLManager.success :
                //success
            try {
                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                JsonObject myJsonObject = parser.parse(response).getAsJsonObject();
                JsonElement status =myJsonObject.get("satatus");
                Log.e("status",status.getAsString());
                if (status.getAsString().trim().contains("true")) {
                    JsonArray allSkills = myJsonObject.getAsJsonArray("skills");
                    Type collectionType = new TypeToken<List<Skills>>() {
                    }.getType();
                    ArrayList<Skills> navigation = gson.fromJson(allSkills, collectionType);
                    afterPraseResult.afterParesResult(navigation, code);
               }
                else
                {
                    afterPraseResult.errorParesResult("cannot get data",code);
                }

            } catch (JsonParseException e) {
                e.printStackTrace();
                afterPraseResult.errorParesResult("cannot get data",code);
            }
                break;
            case URLManager.fail :
                afterPraseResult.errorParesResult(response,code);
                break;
        }
    }

}
