package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.datamanger.DataManger;

import com.example.iti.sidemenumodule.helperclasses.MyProjectCustomerAdapter;
import com.example.iti.sidemenumodule.model.ProjectData;


import java.util.ArrayList;

/**
 * Created by ITI on 01/06/2016.
 */
public class MyProjectListFragment extends Fragment{

    ListView listView;
    View rootView;
    MyProjectCustomerAdapter adapter;
    FragmentActivity myContext;
    ArrayList<ProjectData> data;
    public MyProjectListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.my_project_list_fragment, container, false);
        data= DataManger.getMyProjectData();
        listView=(ListView)rootView.findViewById(R.id.my_project_listview);
        // Getting adapter by passing xml data ArrayList
        adapter=new MyProjectCustomerAdapter(myContext,data);
        listView.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity)activity;
        super.onAttach(activity);
    }
}
