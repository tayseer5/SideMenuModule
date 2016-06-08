package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.app.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.helperclasses.DialogResponce;
import com.example.iti.sidemenumodule.model.Skills;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITI on 06/06/2016.
 */
public class Skills_Alert_Dialog_fragment extends DialogFragment {
    ArrayList<Skills> mSelectedItems;
    ArrayList<String> skillsList;
    CharSequence [] items;
    DialogResponce mListener;
    ArrayList<Skills> allSkillsAsArray;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mSelectedItems = new ArrayList<Skills>();  // Where we track the selected items
        skillsList = new ArrayList<String>();
        String allSkills =  getArguments().getString("skills");
        getSkillsArray(allSkills);
        Log.e("bundle", getArguments().getString("skills")+"");

        items = skillsList.toArray(new CharSequence[skillsList.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(getString(R.string.choose_your_skilss))
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(items, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                   Log.e("selected",which+"");
                                    Log.e("selected",allSkillsAsArray.get(which)+"");
                                    mSelectedItems.add( allSkillsAsArray.get(which));

                                } else if (mSelectedItems.contains(allSkillsAsArray.get(which))) {
                                    // Else, if the item is already in the array, remove it
                                    Log.e("selected",which+"");
                                    Log.e("selected",allSkillsAsArray.get(which)+"");
                                    mSelectedItems.remove(allSkillsAsArray.get(which));
                                }
                            }
                        })
                        // Set the action buttons
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        mListener.result(mSelectedItems);
                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.result(null);
                    }
                });

        return builder.create();

    }

    private void getSkillsArray(String allSkillsAsString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Skills>>() {
        }.getType();
        allSkillsAsArray = gson.fromJson(allSkillsAsString, collectionType);
        for (Skills a : allSkillsAsArray)
        {
            skillsList.add(a.getSkillName());
        }
        Log.e("navigation",allSkillsAsArray.isEmpty()+"");
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (DialogResponce) getTargetFragment();
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement DialogResponce interface");
        }

    }
}
