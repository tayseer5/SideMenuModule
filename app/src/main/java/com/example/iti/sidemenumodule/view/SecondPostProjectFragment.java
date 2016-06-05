package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.datamanger.DataManger;
import com.example.iti.sidemenumodule.model.Project;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SecondPostProjectFragment extends Fragment {
    private static final int PICK_PHOTO_FOR_AVATAR =100 ;
    View rootView;
    FragmentActivity myContext;
    Project project;
    EditText bugetEditText;
    Spinner dateSpinner;
    EditText moreEditText;
    Button attatcmentButton;
    Button doneButton;
    String[] interval={"7"+getString(R.string.days_string),getString(R.string.two_weeks_string),"3"+getString(R.string.three_weeks_string),getString(R.string.month_string),getString(R.string.anytime_string)};
    public SecondPostProjectFragment() {
        // Required empty public constructor
    }

    public SecondPostProjectFragment(Project project) {
        this.project=project;
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
        rootView = inflater.inflate(R.layout.second_post_project_fragment, container, false);
        bugetEditText=(EditText)  rootView.findViewById(R.id.project_budget_edittext);
        moreEditText=(EditText)  rootView.findViewById(R.id.project_more_details_edittext);
        dateSpinner = (Spinner) rootView.findViewById(R.id.date_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, interval);
        dateSpinner.setAdapter(adapter1);
        dateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {
                String date = dateSpinner.getSelectedItem().toString();
                int daysNum=0;
                switch (pos)
                {
                    case 0:
                        daysNum=7;
                        break;
                    case 1:
                        daysNum=14;
                        break;
                    case 2:
                        daysNum=21;
                        break;
                    case 3:
                        daysNum=30;
                        break;
                    default:
                        daysNum=90;
                        break;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, daysNum);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
                SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
                String output = sdf1.format(c.getTime());
                try {
                    project.setProjectDeadLine(sdf1.parse(output));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        attatcmentButton=(Button) rootView.findViewById(R.id.attachment_button);
        attatcmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               pickImage();
            }
        });
        doneButton=(Button) rootView.findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
                String output = sdf1.format(c.getTime());
                try {
                    project.setProjectDeadLine(sdf1.parse(output));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String st=project.getProjectDescription();
                st.concat(" "+moreEditText.getText().toString());
                project.setProjectDescription(st);
                project.setBudget(Integer.parseInt(bugetEditText.getText().toString()));

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }


    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = myContext.getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
        }
    }

}
