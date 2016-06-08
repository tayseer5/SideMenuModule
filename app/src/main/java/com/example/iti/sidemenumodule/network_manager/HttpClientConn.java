package com.example.iti.sidemenumodule.network_manager;

/**
 * Created by ITI on 27/02/2016.
 * this class used to connect to server
 * send to construct the url and hash map of request param and code
 * each error has unique code
 */

import android.content.Context;
import android.util.Log;

import com.example.iti.sidemenumodule.model.Message;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

public class HttpClientConn {
    RequestParams requestParams;
    String URL;
    int code;
    String contentType;
    AfterAsynchronous afterAsynchronous;
    private AsyncHttpClient client = new AsyncHttpClient();
    Context context;

    public HttpClientConn(AfterAsynchronous afterAsynchronous, Context context) {
        try {
            this.afterAsynchronous = afterAsynchronous;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement AfterAsynchronous interface");
        }
        this.context = context;
    }

    public void RequestService(String URL, RequestParams requestParam, final int code, String contentType, int connectionType) {
        this.code = code;

        if (!(URL == null) && !URL.isEmpty()) {
            this.URL = URL;
            if(contentType==null||contentType.isEmpty())
            {
                this.contentType="application/json";
            }
            else
            {
                this.contentType=contentType;
            }
            switch (connectionType) {
                case 0:
                    //post
                    if (requestParam==null)
                    {
                        networkConnectionPostWithoutRequestParam();
                    }
                    else {
                        this.requestParams = requestParam;
                        networkConnectionPost();
                    }

                    break;
                case 1:
                    //get
                    networkConnectionGet();
                    break;
                default:
                    afterAsynchronous.errorInExecute("invalid connection type enter 0 for post and 1 for get");
                    break;
            }


        } else {
            afterAsynchronous.errorInExecute("invalid URL");
        }





    }

    private void networkConnectionPost() {
        client.post(URL, requestParams, new AsyncHttpResponseHandler() {
            Message message;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.e("in scress", "not fail");
                String response = new String(responseBody);
                Log.e("in scress", response);
                afterAsynchronous.afterExecute(response,code);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("in fail getMessage()", error.getMessage());
                Log.e("in fail", error.getLocalizedMessage());
                Log.e("in fail headers", headers[0] + "");
                Log.e("in fail responseBody", new String(responseBody));
                afterAsynchronous.errorInExecute(error.getMessage());

            }

            @Override
            public void onStart() {
                Log.e("in start", "started");

            }

            @Override
            public void onRetry(int retryNo) {

            }
        });
    }
    private void networkConnectionPostWithoutRequestParam() {
        client.post(URL, new AsyncHttpResponseHandler() {
            Message message;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.e("in scress", "not fail");
                String response = new String(responseBody);
                Log.e("in scress", response);
                afterAsynchronous.afterExecute(response,code);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("in fail getMessage()", error.getMessage());
                Log.e("in fail", error.getLocalizedMessage());
                Log.e("in fail headers", headers[0] + "");
                Log.e("in fail responseBody", new String(responseBody));
                afterAsynchronous.errorInExecute(error.getMessage());

            }

            @Override
            public void onStart() {
                Log.e("in start", "started");

            }

            @Override
            public void onRetry(int retryNo) {

            }
        });
    }
    private void networkConnectionGet() {
        HttpEntity httpEntity= null;
        client.get(context, URL, new AsyncHttpResponseHandler() {
            Message message;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.e("in scress", "not fail");
                String response = new String(responseBody);
                    afterAsynchronous.afterExecute(response, code);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("in fail getMessage()", error+"");
                Log.e("in fail headers", headers + "");
                Log.e("in fail responseBody", new String(responseBody));
                afterAsynchronous.errorInExecute(error.getMessage());

            }

            @Override
            public void onStart() {
                Log.e("in start", "started");

            }

            @Override
            public void onRetry(int retryNo) {

            }
        });
    }



}