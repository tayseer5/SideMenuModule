package com.example.iti.sidemenumodule.datamanger;

import com.example.iti.sidemenumodule.helperclasses.MyData;
import com.example.iti.sidemenumodule.model.Category;
import com.example.iti.sidemenumodule.model.Employee;
import com.example.iti.sidemenumodule.model.Portfolio;

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

    public static ArrayList<Portfolio> getPortfolios(int catId) {
        ArrayList data = new ArrayList<Portfolio>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new Portfolio(MyData.id_[i],MyData.nameArray[i],MyData.id_[i],MyData.drawableArrayPortfolio[i],MyData.id_[i]));
        }

        return data;
    }

    public static ArrayList<Employee> getEmployees() {
        ArrayList data = new ArrayList<Employee>();
        for (int i = 0; i < MyData.employeeNameArray.length; i++) {
            data.add(new Employee(MyData.employeeNameArray[i],MyData.employeeTitleArray[i],MyData.rate[i],MyData.drawableArrayEmployee[i]));
        }

        return data;
    }

}
