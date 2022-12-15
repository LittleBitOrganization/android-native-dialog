package com.littlebit.plugins;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.littlebit.popups.MessageHandler.JavaMessageHandlerMock;
import com.littlebit.popups.PopupManager;
import com.littlebit.popups.UnityBridge;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button openAlert = findViewById(R.id.buttonShowAlert);

        JavaMessageHandlerMock javaMessageHandlerMock = new JavaMessageHandlerMock();

        PopupManager.OpenSettingsData settingsData = new PopupManager.OpenSettingsData();
        settingsData.content.text = "NewContent";
        settingsData.title.text = "Title";
        settingsData.buttonNegative.text = "Not Now";
        settingsData.buttonNegative.callbackMessage = "false";

        settingsData.buttonPositive.text ="Ok";
        settingsData.buttonPositive.callbackMessage ="true";

        Gson gson = new Gson();
        String json = gson.toJson(settingsData);

        openAlert.setOnClickListener((view -> {

            UnityBridge.registerMessageHandler(javaMessageHandlerMock);

            UnityBridge.runOnUnityThread(() -> {

                PopupManager.ShowPopupFromUnity("AlertCallback", json);
            });

        }));

    }
}