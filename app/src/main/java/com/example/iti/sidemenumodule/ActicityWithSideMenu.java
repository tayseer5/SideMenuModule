package com.example.iti.sidemenumodule;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.navigationliveo.NavigationLiveo;


public class ActicityWithSideMenu extends NavigationLiveo implements OnItemClickListener {
    private HelpLiveo mHelpLiveo;
    @Override
    public void onInt(Bundle bundle) {
        Log.e("in init","yes");
//This is the Header of side menu
        this.userName.setText("تيسير ابراهيم انور");
        this.userEmail.setText("tayseer.anwar92@gmail.com");
        this.userPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);
        this.userBackground.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);

//Menu Elements
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.homepage), R.drawable.ic_android_black_24dp);
       // mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.dash_board), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.post_project), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.customer_project), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.jop_search), R.drawable.ic_https_black_24dp);
        mHelpLiveo.add(getString(R.string.log_out), R.drawable.ic_https_black_24dp);
        mHelpLiveo.addSeparator();
        with(this) // default theme is dark ,R.color.nliveo_black
                .startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.settings, R.drawable.ic_android_black_24dp)
                .footerSecondItem(R.string.about, R.drawable.ic_android_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
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
    public void onItemClick(int i) {
        Log.e("clicked", i + "");
    }
}