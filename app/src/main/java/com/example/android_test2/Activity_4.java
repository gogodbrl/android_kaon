package com.example.android_test2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Activity_4 extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private int korea_flag = 0;
    private int china_flag = 0;
    private int snack_flag = 0;
    private int japan_flag = 0;
    private int asia_flag = 0;

    private Method method;
    private  String json_str;

    CheckBox korea_checkbox = null;
    CheckBox china_checkbox = null;
    CheckBox snack_checkbox = null;
    CheckBox japan_checkbox = null;
    CheckBox asia_checkbox = null;

    String vaild_value = null;

    public SharedPreferences prefs;
    public SharedPreferences.Editor myeditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        korea_checkbox = (CheckBox) findViewById(R.id.checkbox1);
        china_checkbox = (CheckBox) findViewById(R.id.checkbox2);
        snack_checkbox = (CheckBox) findViewById(R.id.checkbox3);
        japan_checkbox = (CheckBox) findViewById(R.id.checkbox4);
        asia_checkbox = (CheckBox) findViewById(R.id.checkbox5);

        korea_checkbox.setOnCheckedChangeListener(this);
        china_checkbox.setOnCheckedChangeListener(this);
        snack_checkbox.setOnCheckedChangeListener(this);
        japan_checkbox.setOnCheckedChangeListener(this);
        asia_checkbox.setOnCheckedChangeListener(this);

        Button checkbtn = (Button) findViewById(R.id.checkbutton);
        Button savebtn = (Button) findViewById(R.id.savebutton);
        EditText edituser = (EditText) findViewById(R.id.edituser);
        Button getbtn = (Button) findViewById(R.id.getbutton);
        Button removebtn = (Button) findViewById(R.id.removebutton);
        Button clearbtn = (Button) findViewById(R.id.clearbutton);
        Button editsavebtn = (Button) findViewById(R.id.editcheck);

        checkbtn.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        edituser.setOnClickListener(this);
        getbtn.setOnClickListener(this);
        removebtn.setOnClickListener(this);
        clearbtn.setOnClickListener(this);
        editsavebtn.setOnClickListener(this);


        json_str = getResources().getString(R.string.json_file);
        method = new Method();

        prefs = getSharedPreferences("test", MODE_PRIVATE);
        myeditor = prefs.edit();
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*
            korea : 1
            china : 2
            snack : 3
            japan : 4
            asia  : 5
         */
        if (isChecked) {
            if (buttonView.getId() == R.id.checkbox1) {
                korea_flag = 1;
            }
            if (buttonView.getId() == R.id.checkbox2) {
                china_flag = 1;
            }
            if (buttonView.getId() == R.id.checkbox3) {
                snack_flag = 1;
            }
            if (buttonView.getId() == R.id.checkbox4) {
                japan_flag = 1;
            }
            if (buttonView.getId() == R.id.checkbox5) {
                asia_flag = 1;
            }
        } else {
            if (buttonView.getId() == R.id.checkbox1) {
                korea_flag = 0;
            }
            if (buttonView.getId() == R.id.checkbox2) {
                china_flag = 0;
            }
            if (buttonView.getId() == R.id.checkbox3) {
                snack_flag = 0;
            }
            if (buttonView.getId() == R.id.checkbox4) {
                japan_flag = 0;
            }
            if (buttonView.getId() == R.id.checkbox5) {
                asia_flag = 0;
            }
        }
    }
    @Override
    public void onClick(View v) {
        TextView tv = (TextView) findViewById(R.id.checktext);
        TextView saveview = (TextView)findViewById(R.id.savetext);

        switch (v.getId()) {
            case R.id.checkbutton:
                vaild_value = vaildCheck().toString();
                tv.setText(vaild_value);
                break;
            case R.id.savebutton:
                myeditor.putString(vaild_value,method.now_date()+"\n");
                myeditor.commit();
                break;
            case R.id.getbutton :
                Map<String, ?> allEntries = prefs.getAll();
                saveview.setText(allEntries.toString());
                break;
            case R.id.removebutton :
                myeditor.clear();
                myeditor.commit();
                saveview.setText("");
                break;
            case R.id.clearbutton:
                if (korea_checkbox.isChecked()) {
                    korea_checkbox.setChecked(false);
                }
                if (china_checkbox.isChecked()) {
                    china_checkbox.setChecked(false);
                }
                if (snack_checkbox.isChecked()) {
                    snack_checkbox.setChecked(false);
                }
                if (japan_checkbox.isChecked()) {
                    japan_checkbox.setChecked(false);
                }
                if (asia_checkbox.isChecked()) {
                    asia_checkbox.setChecked(false);
                }
                break;
            case R.id.editcheck :
                EditText et = (EditText)findViewById(R.id.edituser);
                String user_str = et.getText().toString();

                myeditor.putString(user_str,method.now_date()+"\n");
                myeditor.commit();
                et.setText("");
                break;

        }
    }
    public Set<String> vaildCheck(){
        Set<String> name_set = new HashSet<>();
        if (korea_flag == 1) {
            ArrayList<String> korea_list = method.get_type_menu(json_str, "korea");
            name_set.add(method.picked(korea_list));
        }
        if (china_flag == 1) {
            ArrayList<String> china_list = method.get_type_menu(json_str, "china");
            name_set.add(method.picked(china_list));
        }
        if (snack_flag == 1) {
            ArrayList<String> snack_list = method.get_type_menu(json_str, "snack");
            name_set.add(method.picked(snack_list));
        }
        if (japan_flag == 1) {
            ArrayList<String> japan_list = method.get_type_menu(json_str, "japan");
            name_set.add(method.picked(japan_list));
        }
        if (asia_flag == 1) {
            ArrayList<String> asia_list = method.get_type_menu(json_str, "asia");
            name_set.add(method.picked(asia_list));
        }
        return name_set;
    }

}
