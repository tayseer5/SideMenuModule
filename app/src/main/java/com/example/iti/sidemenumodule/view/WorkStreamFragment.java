package com.example.iti.sidemenumodule.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.helperclasses.MyPostListAdaptour;
import com.example.iti.sidemenumodule.model.Mypost;

import java.util.ArrayList;


public class WorkStreamFragment extends Fragment implements AdapterView.OnItemClickListener {
    View rootView;
    ListView list;
    MyPostListAdaptour adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.work_strem_fragment, container, false);
        // looping through all song nodes &lt;song&gt;
        ArrayList<Mypost> myposts  = new ArrayList<>();
        for (int i =0 ;i<10;i++)
        {
            Mypost testPost = new Mypost();
            testPost.setProjectName("project "+(i+1));
            testPost.setReplay("Replay"+(i+1));
            myposts.add(testPost);
        }
        list=(ListView)rootView.findViewById(R.id.list);
        // Getting adapter by passing xml data ArrayList
        adapter=new MyPostListAdaptour(this, myposts);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("item click i",i+"");
        Log.e("item click l",l+"");
    }
}

