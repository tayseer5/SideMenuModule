package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.os.Bundle;
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
import com.example.iti.sidemenumodule.helperclasses.EmployeeCustomAdapter;
import com.example.iti.sidemenumodule.model.Employee;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 5/25/2016.
 */
public class EmployeeListFragment extends Fragment {
    ListView listView;
    View rootView;
    FragmentActivity myContext;
    ArrayList<Employee> data;
    public EmployeeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.employeelist_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.employee_listview);
        data= DataManger.getEmployees();
        EmployeeCustomAdapter adapter = new EmployeeCustomAdapter(myContext, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                String slectedItem = data.get(position).getName();
                Toast.makeText(myContext, slectedItem, Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity)activity;
        super.onAttach(activity);
    }
}
