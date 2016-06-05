package com.example.iti.sidemenumodule.helperclasses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Employee;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 6/3/2016.
 */
public class SelectCategoryCustomAdapter extends ArrayAdapter {
    private final Activity context;
    ArrayList<Category> myDate;
    public SelectCategoryCustomAdapter(Activity context, ArrayList<Category> data) {
        super(context, R.layout.select_category_single_row);
        this.context = context;
        myDate=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.select_category_single_row, parent, false);
        TextView nameTextView=(TextView)rowView.findViewById(R.id.category_name_textview);
        nameTextView.setText(myDate.get(position).getName());
        return rowView;

    }

    @Override
    public int getCount() {
        return myDate.size();
    }
}

