package com.example.iti.sidemenumodule.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Portfolio;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 5/23/2016.
 */
public class PortfolioCustomAdapter extends RecyclerView.Adapter<PortfolioCustomAdapter.MyViewHolder> {

    private ArrayList<Portfolio> dataSet;

    private String fontPath = "fonts/NotoNaskhArabic-Regular.ttf";
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public PortfolioCustomAdapter(Context context, ArrayList<Portfolio> data) {
        this.dataSet = data;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.portfolio_cards_layout, parent, false);

        view.setOnClickListener(PortfoliosFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        ImageView imageView = holder.imageViewIcon;
      //  textViewName.setText(dataSet.get(listPosition).getName());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

