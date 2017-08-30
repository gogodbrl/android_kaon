package com.example.android_test2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener
{
	SharedPreferences prefs = null;
	SharedPreferences.Editor myeditor=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*Button btn1 = (Button)findViewById(R.id.btn1);
		Button btn2 = (Button)findViewById(R.id.btn2);*/
		Button btn3 = (Button)findViewById(R.id.btn3);
		Button btn4 = (Button)findViewById(R.id.btn4);
		Button btn5 = (Button)findViewById(R.id.btn5);

		/*btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);*/
        btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);



		prefs = getSharedPreferences("test", MODE_PRIVATE);

		TextView preftext = (TextView)findViewById(R.id.pref);
		preftext.setText(prefs.getAll().toString());
	}
	@Override
	public void onClick(View v){
        Intent intent;
		switch (v.getId()){
		/*	case R.id.btn1 :
				intent = new Intent(this, Activity_2.class);
				startActivity(intent);
				break;
			case R.id.btn2 :
                intent = new Intent(this, Activity_3.class);
                startActivity(intent);
                break;*/
            case R.id.btn3 :
                intent = new Intent(this, Activity_4.class);
                startActivity(intent);
                break;
			case R.id.btn4 :
				intent = new Intent(this, Activity_5.class);
				startActivity(intent);
				break;
			case R.id.btn5 :
				intent = new Intent(this, Activity_6.class);
				startActivity(intent);
				break;
		}
	}
}
