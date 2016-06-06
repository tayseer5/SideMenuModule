package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.daos.EmployeeManger;
import com.example.iti.sidemenumodule.datamanger.DataManger;
import com.example.iti.sidemenumodule.helperclasses.EmployeeCustomAdapter;
import com.example.iti.sidemenumodule.model.Employee;
import com.example.iti.sidemenumodule.model.Users;
import com.example.iti.sidemenumodule.network_manager.AfterPraseResult;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 5/25/2016.
 */
public class EmployeeListFragment extends Fragment implements AfterPraseResult {

    ListView listView;
    View rootView;
    FragmentActivity myContext;
    ArrayList<Users> data;
    ProgressDialog progress;
    EmployeeCustomAdapter adapter;
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
        data=new ArrayList<>();
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.employeelist_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.employee_listview);
        progress = new ProgressDialog(myContext,R.style.MyTheme);
        progress.setCancelable(false);
        progress.show();
        EmployeeManger employeeManger=EmployeeManger.getInstance(myContext);
        employeeManger.getEmployeesList(this);
        adapter = new EmployeeCustomAdapter(myContext, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                String slectedItem = data.get(position).getUserName();
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

    @Override
    public void afterParesResult(ArrayList list) {
        data=list;
        adapter.getData().clear();
        adapter.getData().addAll(data);
        // fire the event
        adapter.notifyDataSetChanged();
        progress.dismiss();
    }

    @Override
    public void errorParesResult(String errorMessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(myContext).create();
        alertDialog.setTitle(getString(R.string.alert));
        alertDialog.setMessage(errorMessage);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
