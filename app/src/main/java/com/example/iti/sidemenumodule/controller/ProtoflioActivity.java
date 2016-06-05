package com.example.iti.sidemenumodule.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.view.AddPortfolioItemFragment;
import com.example.iti.sidemenumodule.view.PortfoliosFragment;
import com.example.iti.sidemenumodule.view.ProfileFragment;

public class ProtoflioActivity extends ActionBarActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protoflio);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MedicineActivity.this, "Alarm....", Toast.LENGTH_LONG).show();
                NavUtils.navigateUpFromSameTask(ProtoflioActivity.this);
            }
        });
        //lazm ta50d object men user
        Fragment fragment=new PortfoliosFragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fragment, fragment, "PortolioFragment");
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_protoflio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item_add_project){
            Log.i("test action bar item","indeed");
            Fragment fragment=new AddPortfolioItemFragment();
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.fragment, fragment, "AddPortfolioItemFragment");
            transaction.addToBackStack("AddPortfolioItemFragment").commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
