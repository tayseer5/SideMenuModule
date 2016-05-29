package com.example.iti.sidemenumodule.helperclasses;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.model.Employee;

import java.util.ArrayList;

/**
 * Created by Rehab El-Kasaby on 3/3/2016.
 */
public class EmployeeCustomAdapter extends ArrayAdapter {
    private final Activity context;
    ArrayList<Employee> myDate;
    public EmployeeCustomAdapter(Activity context, ArrayList<Employee> data) {
        super(context, R.layout.employee_single_row);
        this.context = context;
        myDate=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.employee_single_row, parent, false);
        TextView nameTextView=(TextView)rowView.findViewById(R.id.employee_name_textview);
        TextView titleTextView=(TextView)rowView.findViewById(R.id.employee_title_textview);
        ImageView imageView=(ImageView)rowView.findViewById(R.id.employee_image);
        RatingBar ratingBar=(RatingBar)rowView.findViewById(R.id.rating);

        nameTextView.setText(myDate.get(position).getName());
        titleTextView.setText(myDate.get(position).getTitle());
        imageView.setImageResource(myDate.get(position).getImage());
        ratingBar.setRating((float) myDate.get(position).getRate());
        return rowView;

    }

    @Override
    public int getCount() {
        return myDate.size();
    }
}
