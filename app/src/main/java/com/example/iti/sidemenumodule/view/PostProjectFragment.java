package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.datamanger.DataManger;
import com.example.iti.sidemenumodule.helperclasses.EmployeeCustomAdapter;
import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Employee;
import com.example.iti.sidemenumodule.model.Project;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 5/30/2016.
 */
public class PostProjectFragment extends Fragment{
    View rootView;
    FragmentActivity myContext;
    Button nextButton;
    EditText detailsEditText;
    EditText skillsEditText;
    EditText titleEditText;
    Spinner categorySpinner;
    Project project;
    ArrayList<Category> categoryList;
    String[] categoryNames;
    public PostProjectFragment() {
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
        rootView = inflater.inflate(R.layout.postproject_fragment, container, false);
        nextButton=(Button)rootView.findViewById(R.id.next_button);
        titleEditText=(EditText)rootView.findViewById(R.id.project_title_edittext);
        detailsEditText=(EditText)rootView.findViewById(R.id.project_details_edittext);
        skillsEditText=(EditText)rootView.findViewById(R.id.project_skills_edittext);
        project=new Project();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setProjectName(titleEditText.getText().toString());
                project.setProjectDescription(detailsEditText.getText().toString());
                project.setProjectSkills(skillsEditText.getText().toString());
                SecondPostProjectFragment secondPostProjectFragment=new SecondPostProjectFragment(project);
                FragmentManager manager=myContext.getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fragment, secondPostProjectFragment, "secondPostProjectFragment");
                transaction.addToBackStack("secondPostProjectFragment").commit();
            }
        });
        categoryList=DataManger.getcategories();
        //categoryNames=getCategoryNames();
        categorySpinner = (Spinner) rootView.findViewById(R.id.category_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, categoryNames);
        categorySpinner.setAdapter(adapter1);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {
                String categoryName = categorySpinner.getSelectedItem().toString();
//                int categoryId = getCategoryIdByName(categoryName);
                int categoryId=1;
                if (categoryId != -1) {
                    project.setCategory(categoryId);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                project.setCategory(0);
            }

        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

//    private String[] getCategoryNames()
//    {
//        String[] names=new String[categoryList.size()];
//        for(int i=0;i<categoryList.size();i++)
//        {
//            names[i]=categoryList.get(i).getName();
//        }
//        return names;
//    }
//    private int getCategoryIdByName(String name)
//    {
//        for(int i=0;i<categoryList.size();i++)
//        {
//           if(categoryList.get(i).getName().equals(name))
//           {
//               return categoryList.get(i).getId();
//           }
//        }
//        return -1;
//    }
}
