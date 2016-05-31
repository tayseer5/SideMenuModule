package com.example.iti.sidemenumodule.helperclasses;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.model.Mypost;

import java.util.ArrayList;

/**
 * Created by ITI on 25/05/2016.
 */
public class MyPostListAdaptour extends BaseAdapter {
    private Fragment fragment;
    private ArrayList<Mypost> potsData;
    private static LayoutInflater inflater=null;

    public MyPostListAdaptour( Fragment fragment,ArrayList<Mypost> potsData) {
        this.potsData = potsData;
        this.fragment = fragment;


        inflater =  (LayoutInflater) fragment.getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return potsData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        if(convertView==null)
        row = inflater.inflate(R.layout.my_post_row, null);
        TextView projectName = (TextView)row.findViewById(R.id.project_name); // title
        TextView details = (TextView)row.findViewById(R.id.details); // artist name
        ImageView thumb_image=(ImageView)row.findViewById(R.id.list_image); // thumb image
        Mypost postDate = potsData.get(position);
        // Setting all values in listview
        projectName.setText(postDate.getProjectName());
        details.setText(postDate.getReplay());
        return row;
    }
}
