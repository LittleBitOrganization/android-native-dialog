package com.littlebit.popups;

public class Example {

    public static void ShowMessagePopup() {

        UnityBridge.runOnUnityThread(() -> {
            UnityBridge.runOnUnityThread(() -> {

//                PopupManager.ShowMessagePopup("Title", "cool message", "Ok.");
            });
        });
    }
}
