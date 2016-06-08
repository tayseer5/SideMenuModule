package com.example.iti.sidemenumodule.network_manager;

import com.example.iti.sidemenumodule.model.Message;

/**
 * Created by ITI on 04/06/2016.
 */
public interface AfterPraseResult {
    public void afterParesResult(Object message, int code);
    public void errorParesResult(String errorMessage,int code);

}


