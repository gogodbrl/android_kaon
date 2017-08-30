package com.example.android_test2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Activity_5 extends Activity implements View.OnClickListener{
    private TextView tv_name;
    private TextView tv_menu;
    private TextView tv2;
    private Button btn_random;
    private Button btn_random_close;
    private Button btn_random_retry;
    private Button btn_random_menu;

    private Set<String> name_set = new HashSet<>();
    private ArrayList<String> name_list;
    private Method method;
    private String json_str;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        tv_name = (TextView)findViewById(R.id.random_tv);
        tv_menu = (TextView)findViewById(R.id.random_tv1);
        tv2 = (TextView)findViewById(R.id.random_tv2);

        btn_random = (Button)findViewById(R.id.random_btn);
        btn_random_close = (Button)findViewById(R.id.random_btn_close);
        btn_random_retry = (Button)findViewById(R.id.random_btn_retry);
        btn_random_menu = (Button)findViewById(R.id.random_btn_menu);

        btn_random.setOnClickListener(this);
        btn_random_close.setOnClickListener(this);
        btn_random_retry.setOnClickListener(this);
        btn_random_menu.setOnClickListener(this);

        method = new Method();
        json_str = getResources().getString(R.string.json_file);
        name_set = get_name(json_str);
        name_list = new ArrayList<>(name_set);

        tv_name.setText(method.picked(name_list));
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.random_btn :
                tv_menu.setText(name_list.toString());
                break;
            case R.id.random_btn_close :
                tv_menu.setText("");
                break;
            case R.id.random_btn_retry :
                tv_name.setText(method.picked(name_list));
                break;
            case R.id.random_btn_menu :
                String list_string = "";
                ArrayList<String> al = method.get_name_menu(json_str, tv_name.getText().toString());
                for (String s : al ) {
                    list_string += s + "\n";
                }
                tv2.setText(list_string);
                break;
        }
    }
    private Set<String> get_name(String json_str){
        Set name_set = new HashSet<>();
        try {
            JSONArray jarray = method.json_parsing(json_str);
            for (int idx=0; idx<jarray.length(); idx++){
                JSONObject jObject = jarray.getJSONObject(idx);
                String name = jObject.getString("name");
                name_set.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name_set;
    }
}
