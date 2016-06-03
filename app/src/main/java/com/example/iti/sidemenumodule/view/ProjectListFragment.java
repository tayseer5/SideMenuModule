package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.datamanger.DataManger;
import com.example.iti.sidemenumodule.helperclasses.MyProjectCustomerAdapter;
import com.example.iti.sidemenumodule.helperclasses.ProjectCustomeAdapter;
import com.example.iti.sidemenumodule.model.ProjectData;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by ITI on 01/06/2016.
 */
public class ProjectListFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    View rootView;
    ProjectCustomeAdapter adapter;
    FragmentActivity myContext;
    ArrayList<ProjectData> data;

    public ProjectListFragment(int id) {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.search_for_jop_fragment, container, false);
        data= DataManger.getProjectData();
        listView=(ListView)rootView.findViewById(R.id.jops_listview);
        // Getting adapter by passing xml data ArrayList
        adapter=new ProjectCustomeAdapter(myContext,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity)activity;
        super.onAttach(activity);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        ProjectData item = data.get(i);
        Gson gson = new Gson();
        String myJson = gson.toJson(item);
        Intent projectDetails = new Intent(getActivity(),ProjectDetails.class);
        projectDetails.putExtra("product_object",myJson);
        startActivity(projectDetails);

        }
}
