package com.littlebit.popups;

import android.os.Handler;

import com.littlebit.popups.MessageHandler.JavaMessageHandler;

public final class UnityBridge {
    // Содержит ссылку на C# реализацию интерфейса
    private static JavaMessageHandler javaMessageHandler;
    // Перенаправляет вызов в Unity поток
    private static Handler unityMainThreadHandler;


    //Вызывается из Unity
    public static void registerMessageHandler(JavaMessageHandler handler) {
        javaMessageHandler = handler;
        if(unityMainThreadHandler == null) {
            // Так как эту функцию вызываем всегда на старте Unity,
            // этот вызов идет из нужного нам в дальнейшем потока,
            // создадим для него Handler
            unityMainThreadHandler = new Handler();
        }
    }

    public static void runOnUnityThread(Runnable runnable) {
        if(unityMainThreadHandler != null && runnable != null) {
            unityMainThreadHandler.post(runnable);
        }
    }

    public static void sendMessageToUnity(final String message, final String data) {
        runOnUnityThread(() -> {
            if(javaMessageHandler != null) {
                javaMessageHandler.OnMessage(message, data);
            }
        });
    }
}
