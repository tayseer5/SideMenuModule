package com.example.iti.sidemenumodule.helperclasses;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.model.ProjectData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by ITI on 01/06/2016.
 */
public class ProjectCustomeAdapter extends ArrayAdapter {
    private static class ViewHolderItem {
        ImageView projectImage;
        TextView projectName;
        TextView projectEndDate;
        TextView projectSalary;
        TextView projectClient;
    }

    private final Activity context;
    ArrayList<ProjectData> myDate;
    public ProjectCustomeAdapter(Activity context, ArrayList<ProjectData> data) {
        super(context, R.layout.project_post_row);
        this.context = context;
        myDate=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        if(convertView==null){

            // inflate the layout
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.project_post_row, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.projectName = (TextView) convertView.findViewById(R.id.project_name);
            viewHolder.projectSalary = (TextView) convertView.findViewById(R.id.price);
            viewHolder.projectEndDate = (TextView) convertView.findViewById(R.id.max_deadline);
            viewHolder.projectClient = (TextView) convertView.findViewById(R.id.client_name);
            // store the holder with the view.
            convertView.setTag(viewHolder);

        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // object item based on the position
        ProjectData objectItem =myDate.get(position);
        Log.e("length of data adaptour", myDate.size() + "");
        // assign values if the object is not null
        if(objectItem != null) {
            viewHolder.projectName.setText(objectItem.getProjectName());
            viewHolder.projectEndDate.setText(objectItem.getEndDate());
            viewHolder.projectSalary.setText(objectItem.getSalary());
            viewHolder.projectClient.setText(objectItem.getSupplerName());
        }

        return convertView;

    }

    @Override
    public int getCount() {
        return myDate.size();
    }

}


