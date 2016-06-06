package com.example.iti.sidemenumodule.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.controller.ProfileActivity;
import com.example.iti.sidemenumodule.controller.ProtoflioActivity;
import com.example.iti.sidemenumodule.model.Portfolio;
import com.example.iti.sidemenumodule.model.Users;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    View rootView;
    FragmentActivity myContext;
    Users user;
    Button portfolioButton;
    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(Users user) {
        this.user=user;
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
        rootView=inflater.inflate(R.layout.fragment_profile, container, false);
        if(user!=null)
        {
           // fill profile with data
        }
        portfolioButton=(Button) rootView.findViewById(R.id.protolio_button);
        portfolioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(myContext,ProtoflioActivity.class);
                startActivity(profileIntent);
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
