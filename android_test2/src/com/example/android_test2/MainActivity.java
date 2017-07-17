package com.example.android_test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


//activity로 변경하니까 intent성공
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void mOnClick(View v){
		Intent intent = new Intent(this, Activity_2.class);
		startActivity(intent);
	}
	public void mOnClick2(View v){
		Intent intent = new Intent(this, Activity_3.class);
		startActivity(intent);
	}
}
