package com.example.iti.sidemenumodule.helperclasses;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
public class MyProjectCustomerAdapter extends ArrayAdapter {
    //to Cash my layout element
    private static class ViewHolderItem {
        PieChart pieChart;
        TextView myProjectName;
        TextView myProjectStartDate;
        TextView myProjectEndDate;
        TextView myProjectSalary;
        TextView myProjectSate;
    }

    private final Activity context;
    ArrayList<ProjectData> myDate;
    public MyProjectCustomerAdapter(Activity context, ArrayList<ProjectData> data) {
        super(context, R.layout.my_project_row);
        this.context = context;
        myDate=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        if(convertView==null){

            // inflate the layout
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.my_project_row, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.pieChart = (PieChart) convertView.findViewById(R.id.pie_chart);
            viewHolder.myProjectName = (TextView) convertView.findViewById(R.id.my_project_name);
            viewHolder.myProjectSalary = (TextView) convertView.findViewById(R.id.my_project_price);
            viewHolder.myProjectSate = (TextView) convertView.findViewById(R.id.my_project_state);
            viewHolder.myProjectEndDate = (TextView) convertView.findViewById(R.id.my_project_end_date);
            viewHolder.myProjectStartDate = (TextView) convertView.findViewById(R.id.my_project_start_date);
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

           PieData data =DrawMyPieCart(objectItem.getPresentgeOfFinsh());
            //  get the pieChart from the ViewHolder and then set data into chart
            viewHolder.pieChart.setData(data);
            viewHolder.pieChart.setCenterText("hello");  // set the description
            viewHolder.pieChart.setUsePercentValues(true);
            viewHolder.pieChart.setDrawSliceText(true);
            viewHolder.pieChart.setTransparentCircleRadius(9f);
            viewHolder.pieChart.setDescription("");  // set the description
            viewHolder.pieChart.setClickable(false);
            viewHolder.myProjectName.setText(objectItem.getProjectName());
            viewHolder.myProjectStartDate.setText(objectItem.getStartDate());
            viewHolder.myProjectEndDate.setText(objectItem.getEndDate());
            viewHolder.myProjectSate.setText(objectItem.getState());
        }

        return convertView;

    }

    private PieData DrawMyPieCart(float progress)
    {
        //data of chart see if you move it to outer function
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(progress, 0));
        entries.add(new Entry(100-progress, 1));
        //pass argument to pie dara set
        PieDataSet dataSet = new PieDataSet(entries,null);
//            // creating labels
        ArrayList<String> labels = new ArrayList<>();
        labels.add("");
        labels.add("");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS); // set the color
        dataSet.setSliceSpace(3f);
        // initialize Piedata
        PieData data = new PieData(labels,dataSet);
        data.removeXValue(0);
        data.removeXValue(0);
        return data;
    }
    @Override
    public int getCount() {
        return myDate.size();
    }

}
