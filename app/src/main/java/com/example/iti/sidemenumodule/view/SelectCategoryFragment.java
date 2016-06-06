package com.example.iti.sidemenumodule.view;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.datamanger.DataManger;
import com.example.iti.sidemenumodule.helperclasses.EmployeeCustomAdapter;
import com.example.iti.sidemenumodule.helperclasses.MyData;
import com.example.iti.sidemenumodule.helperclasses.SelectCategoryCustomAdapter;
import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Employee;
import com.example.iti.sidemenumodule.model.Portfolio;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectCategoryFragment extends Fragment {


    ListView listView;
    View rootView;
    FragmentActivity myContext;
    ArrayList<Category> data;

    public SelectCategoryFragment() {
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
        rootView = inflater.inflate(R.layout.fragment_select_category, container, false);
        listView = (ListView) rootView.findViewById(R.id.select_category_listview);
        data = DataManger.getcategories();
        SelectCategoryCustomAdapter adapter = new SelectCategoryCustomAdapter(myContext, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                int selectedItemId = data.get(position).getId();
                int selectedItemId =1;
                        Portfolio portfolio = new Portfolio();
                portfolio.setCategoryId(selectedItemId);
                android.support.v4.app.Fragment fragment = new AddPortfolioItemFragment(portfolio);
                FragmentManager manager = myContext.getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment, fragment, "AddPortfolioItemFragment");
                transaction.addToBackStack("AddPortfolioItemFragment").commit();

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }
}
