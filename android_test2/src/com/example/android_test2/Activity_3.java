package com.example.android_test2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_3 extends Activity {
	TextView tv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_3);
		
		tv = (TextView)findViewById(R.id.jid);
		json_parsing(tv);

	}
	public TextView json_parsing(TextView tv){
		
		StringBuffer man_list = new StringBuffer();
		String str =
			    "[{'name':'배트맨','age':43,'address':'고담'},"+
			    "{'name':'슈퍼맨','age':36,'address':'뉴욕'},"+
			    "{'name':'앤트맨','age':25,'address':'LA'}]";

		try {
			JSONArray jarray = new JSONArray(str);
			for(int idx=0; idx<jarray.length(); idx++){
				JSONObject jObject = jarray.getJSONObject(idx);
				String name= jObject.getString("name");
				String address = jObject.getString("address");
				int age = jObject.getInt("age");
				
				man_list.append(
                        "주소:" + address +
                        "이름:" + name +
                        "나이:" + age + "\n"
                    );
			}
			tv.setText(man_list.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tv;
		
	}
}
