package com.littlebit.popups.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.littlebit.popups.R;



public class CustomDialog extends Dialog{
    private Activity activity;
    private Button btnNegative, btnNeutral, btnPositive;
    private TextView textTitle, textContent;

    public CustomDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert);

        btnPositive = findViewById(R.id.alert_btn_positive);
        btnNegative = findViewById(R.id.alert_btn_negative);
        btnNeutral = findViewById(R.id.alert_btn_neutral);
        textTitle = findViewById(R.id.alert_text_title);
        textContent = findViewById(R.id.alert_text_content);
        DisableAllButtons();
        DisableAllTextView();
    }

    private void DisableAllTextView() {
        textTitle.setVisibility(View.GONE);
        textContent.setVisibility(View.GONE);
    }

    private void DisableAllButtons() {
        btnPositive.setVisibility(View.GONE);
        btnNegative.setVisibility(View.GONE);
        btnNeutral.setVisibility(View.GONE);
    }

    public void SetTitleText(String text) {
        SetText(textTitle, text);
    }

    public void SetContentText(String text) {
        SetText(textContent, text);
    }

    public void AddPositiveButton(String text, View.OnClickListener onClick) {
        AddButton(btnPositive, text, onClick);
    }

    public void AddNegativeButton(String text, View.OnClickListener onClick) {
        AddButton(btnNegative, text, onClick);
    }

    public void AddNeutralButton(String text, View.OnClickListener onClick) {
        AddButton(btnNeutral, text, onClick);
    }

    private void AddButton(Button button, String text, View.OnClickListener onClick) {
        button.setVisibility(View.VISIBLE);
        button.setText(text);
        button.setOnClickListener(onClick);
    }

    private void SetText (TextView textView, String text) {
        textView.setVisibility(View.VISIBLE);
        textView.setEnabled(true);
        textView.setText(text);
    }



//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_yes:
//                activity.finish();
//                break;
//            case R.id.btn_no:
//                dismiss();
//                break;
//            default:
//                break;
//        }
//        dismiss();
//    }

}