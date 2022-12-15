package com.littlebit.popups.MessageHandler;

import android.util.Log;

import com.littlebit.popups.Tag;

public class JavaMessageHandlerMock implements JavaMessageHandler{
    @Override
    public void OnMessage(String message, String data) {

        Log.e(Tag.main, "JavaMessageHandlerMock: " + message + ": " + data);
    }
}
