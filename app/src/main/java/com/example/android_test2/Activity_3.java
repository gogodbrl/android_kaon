package com.example.android_test2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity_3 extends Activity {
	TextView tv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_3);
		
		tv = (TextView)findViewById(R.id.jid);
		json_parsing(tv);
	}
	private TextView json_parsing(TextView tv){
		StringBuffer man_list = new StringBuffer();

		String json_str = getResources().getString(R.string.json_file);

		try {
			JSONArray jarray = new JSONArray(json_str);
			for(int idx=0; idx<jarray.length(); idx++){
				JSONObject jObject = jarray.getJSONObject(idx);
				String name= jObject.getString("name");
				String type = jObject.getString("type");
				int distince = jObject.getInt("distince");
				
				man_list.append(
                        " name : " + name +
                        " distince : " + distince +
                        " type : " + type + "\n"
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
