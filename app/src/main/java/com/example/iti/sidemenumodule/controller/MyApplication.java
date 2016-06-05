package com.example.iti.sidemenumodule.controller;

import android.app.Application;
import android.graphics.Typeface;

import com.norbsoft.typefacehelper.TypefaceCollection;
import com.norbsoft.typefacehelper.TypefaceHelper;

/**
 * Created by Loma&M on 18/05/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceCollection typeface=new TypefaceCollection.Builder()
                .set(Typeface.NORMAL,Typeface.createFromAsset(getAssets(),"fonts/DroidKufi-Regular.ttf"))
                .set(Typeface.BOLD, Typeface.createFromAsset(getAssets(), "fonts/DroidKufi-Bold.ttf"))
                .create();
        TypefaceHelper.init(typeface);

    }
}
