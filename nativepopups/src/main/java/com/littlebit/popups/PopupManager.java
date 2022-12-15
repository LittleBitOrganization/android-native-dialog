package com.littlebit.popups;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.gson.Gson;
import com.littlebit.popups.Dialog.CustomDialog;

import org.json.JSONException;
import org.json.JSONObject;


public class PopupManager {

    public static class OpenSettingsData {

        public TextSettings title = new TextSettings();
        public TextSettings content = new TextSettings();
        public ButtonSettings buttonPositive = new ButtonSettings();
        public ButtonSettings buttonNegative = new ButtonSettings();
        public ButtonSettings buttonNeutral = new ButtonSettings();

        public OpenSettingsData() {

        }


        public class ButtonSettings {

            public String text;
            public String callbackMessage;

            public ButtonSettings() {
                text = null;
            }

            public boolean isEnable() {
                return text != null && text.isEmpty() == false;
            }
        }

        public class TextSettings {
            public String text;

            public TextSettings() {
                text = null;
            }

            public boolean isEnable() {
                return text != null && text.isEmpty() == false;
            }
        }

    }

    public static class PopupBuilder {

        private CustomDialog customDialog;
        private View.OnClickListener closeListener;

        public PopupBuilder(CustomDialog customDialog) {
            this.customDialog = customDialog;

            customDialog.setOnKeyListener(((dialogInterface, keyCode, keyEvent) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK) {

                    if(closeListener != null)
                        closeListener.onClick(null);
                    dialogInterface.dismiss();
                }
                return false;
            }));
        }

        public void AddCloseByKeycodeBack(View.OnClickListener clickListener) {
            closeListener = clickListener;
        }

        public PopupBuilder AddPositiveButton(String text, View.OnClickListener onClickListener) {

            customDialog.AddPositiveButton(text, (view) -> {
                customDialog.cancel();
                onClickListener.onClick(view);
            });
            return this;
        }

        public PopupBuilder AddNegativeButton(String text, View.OnClickListener onClickListener) {

            customDialog.AddNegativeButton(text, (view) -> {
                customDialog.cancel();
                onClickListener.onClick(view);
            });
            return this;
        }

        public PopupBuilder AddNeutralButton(String text, View.OnClickListener onClickListener) {
            customDialog.AddNeutralButton(text, (view) -> {
                customDialog.cancel();
                onClickListener.onClick(view);
            });
            return this;
        }

        public PopupBuilder SetTitle(String text) {
            customDialog.SetTitleText(text);
            return this;
        }

        public PopupBuilder SetContent(String text) {
            customDialog.SetContentText(text);

            return this;
        }
    }

    private static Context context;

    public PopupManager(Context context) {

        this.context = context;
    }

    public static void ShowPopupFromUnity(String tag, String settings) {

        Gson gson = new Gson();
        OpenSettingsData settingsData = gson.fromJson(settings, OpenSettingsData.class);

        PopupBuilder popupBuilder = ShowMessagePopup();

        if (settingsData.buttonPositive.isEnable()) {
            popupBuilder.AddPositiveButton(settingsData.buttonPositive.text, (v) ->
                    UnityBridge.sendMessageToUnity(tag, settingsData.buttonPositive.callbackMessage));

        }
        if (settingsData.buttonNegative.isEnable()) {
            popupBuilder.AddNegativeButton(settingsData.buttonNegative.text, (v) ->
                    UnityBridge.sendMessageToUnity(tag, settingsData.buttonNegative.callbackMessage));

            popupBuilder.AddCloseByKeycodeBack((v) -> {
                UnityBridge.sendMessageToUnity(tag, settingsData.buttonNegative.callbackMessage);
            });
        }
        if(settingsData.buttonNeutral.isEnable()) {
            popupBuilder.AddNeutralButton(settingsData.buttonNeutral.text, (v) ->
                    UnityBridge.sendMessageToUnity(tag, settingsData.buttonNeutral.callbackMessage));
        }
        if(settingsData.title.isEnable()){
            popupBuilder.SetTitle(settingsData.title.text);
        }
        if(settingsData.content.isEnable()) {
            popupBuilder.SetContent(settingsData.content.text);
        }


    }


    public static PopupBuilder ShowMessagePopup() {

        CustomDialog customDialog = new CustomDialog((Activity) context);
        PopupBuilder popupBuilder = new PopupBuilder(customDialog);
        customDialog.setCancelable(false);
        customDialog.show();
        return popupBuilder;

    }

//    @SuppressLint("InlinedApi")
//    private static int GetTheme() {
//        int theme = 0;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            theme = android.R.style.Theme_Material_Light_Dialog;
//        } else {
//            theme = android.R.style.Theme_Holo_Dialog;
//        }
//        return theme;
//    }


}
