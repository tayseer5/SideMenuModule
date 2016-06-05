package com.example.iti.sidemenumodule.network_manager;

import com.example.iti.sidemenumodule.model.Message;

/**
 * Created by ITI on 27/02/2016.
 */
public interface AfterAsynchronous {
    public void afterExecute(Message message, int code);
    public void errorInExecute(String errorMessage);



}
