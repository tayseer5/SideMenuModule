package com.example.iti.sidemenumodule;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ahmed_telnet on 5/21/2016.
 */
public class ProductFragment extends Fragment {
    View rootView;
    FragmentActivity myContext;
    int categoryID;

    public ProductFragment() {
        // Required empty public constructor
    }


    public ProductFragment(int id) {

        categoryID=id;
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
        rootView = inflater.inflate(R.layout.product_fragment, container, false);
        TextView textView=(TextView) rootView.findViewById(R.id.textView2);
        textView.setText(categoryID+"");
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity)activity;
        super.onAttach(activity);
    }
}
