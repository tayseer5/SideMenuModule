package com.example.iti.sidemenumodule.datamanger;

import com.example.iti.sidemenumodule.helperclasses.MyData;
import com.example.iti.sidemenumodule.model.Category;

import java.util.ArrayList;

/**
 * Created by Ahmed_telnet on 5/23/2016.
 */
public class DataManger {
    public static ArrayList<Category> getcategories() {
        ArrayList data = new ArrayList<Category>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new Category(
                    MyData.nameArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

        return data;
    }
}
