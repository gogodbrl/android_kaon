package com.example.android_test2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Activity_6 extends Activity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myeditor = prefs.edit();
        myeditor.putString("Name", "TEST2");
        myeditor.commit();
    }
    @Override
    public void onClick(View v){

    }
}
