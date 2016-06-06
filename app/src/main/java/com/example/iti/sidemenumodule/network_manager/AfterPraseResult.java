package com.example.iti.sidemenumodule.network_manager;

import com.example.iti.sidemenumodule.model.Message;

import java.util.ArrayList;

/**
 * Created by ITI on 04/06/2016.
 */
public interface AfterPraseResult {
    public void afterParesResult(ArrayList list);
    public void errorParesResult(String errorMessage);

}


