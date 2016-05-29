package com.example.iti.sidemenumodule.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.example.iti.sidemenumodule.view.EmployeeListFragment;
import com.example.iti.sidemenumodule.view.MainFragment;
import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.view.RegistrationActivity;
import com.example.iti.sidemenumodule.view.WorkStreamFragment;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.navigationliveo.NavigationLiveo;


public class ActicityWithSideMenu extends NavigationLiveo implements OnItemClickListener {
    private HelpLiveo mHelpLiveo;
    @Override
    public void onInt(Bundle bundle) {
        Log.e("in init", "yes");

//Menu Elements
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.homepage), R.drawable.ic_android_black_24dp);
       // mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.dash_board), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.post_project), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.customer_project), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.jop_search), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.search_about_handCraft), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.settings), R.drawable.ic_android_black_24dp);
        mHelpLiveo.add(getString(R.string.about), R.drawable.ic_android_black_24dp);
        mHelpLiveo.add(getString(R.string.log_out), R.drawable.ic_android_black_24dp);
        //is not login
        if(IsNotLogin())
        {
            mHelpLiveo.add(getString(R.string.sigin_in), R.drawable.ic_https_black_24dp);
        }
        else {
            //This is the Header of side menu
            this.userName.setText("تيسير ابراهيم انور");
            this.userEmail.setText("tayseer.anwar92@gmail.com");
            this.userPhoto.setImageResource(R.drawable.ic_rudsonlive);
            this.userBackground.setImageResource(R.drawable.ic_user_background_first);
            this.userBackground.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);


        }
Resources.Theme x =with(this).getTheme();
        Log.e("the theam", x + "");
        with(this,1) // default theme is dark ,R.color.nliveo_black
                .startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .removeFooter()
                .build();


    }
    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("onClickFooter","onClickFooter");
            closeDrawer();
        }
    };
    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("onClickPhoto","onClickPhoto");
            closeDrawer();
        }
    };
    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
            Log.e("onPrepareOptionsMenu","onPrepareOptionsMenu");
        }
    };


    @Override
    public void onItemClick(int position) {
        Fragment mFragment=null;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 2:
                mFragment=new WorkStreamFragment();
                break;
            case 4:
                mFragment = new EmployeeListFragment();
                break;
            case 5:
                if (IsNotLogin())
                {
                    Intent intent = new Intent(this,RegistrationActivity.class);
                    startActivity(intent);
                    Log.e("in if","in if");
                }
                else
                {
                    Log.e("in else","in else");
                    //remove shared prefrence
                }
                break;
            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }
    private boolean IsNotLogin()
    {
        SharedPreferences sharedpreferences = getSharedPreferences("loginPrefrence", Context.MODE_PRIVATE);
        String isLogin = sharedpreferences.getString("mail","Not login");
        return isLogin.contentEquals("Not login");


    }

    @Override
    protected void onStop() {
        Log.e("onStop","onStop");
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        Log.e("onPostResume","onPostResume");
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        Log.e("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.e("onRestart","onRestart");
        if(!IsNotLogin())
        {
            Log.e("reload","on Int");

        }
        super.onRestart();
    }
}