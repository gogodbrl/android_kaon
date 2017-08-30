package com.example.android_test2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Method {

    public JSONArray json_parsing(String json_str) {
        try {
            JSONArray jarray = new JSONArray(json_str);
            return jarray;
        } catch (JSONException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> get_name_menu(String json_str, String name){
        // name에 대한 메뉴를 json으로 보고 불러오는 method
        ArrayList<String> menu_list = new ArrayList<>();
        try {
            Log.d("Activity_method", name);
            JSONArray json_array = json_parsing(json_str);
            for ( int idx=0; idx<json_array.length(); idx++){
                JSONObject job = json_array.getJSONObject(idx);
                String name_elem = job.getString("name");
                String menu_elem = job.getString("menu");
                if (name.equals(name_elem)) {
                    menu_list.add(menu_elem);
                    Log.d("Activity_method","True");
                }else{
                    Log.d("Activity_method","False");
                }
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
        Log.d("Activity_method", menu_list.toString());
        return menu_list;
    }
    public ArrayList<String> get_type_menu(String json_str, String type){
        ArrayList<String> type_list = new ArrayList<>();
        try {
            Log.d("Activity_method",  type);
            JSONArray json_array = json_parsing(json_str);
            for (int idx=0; idx<json_array.length(); idx++){
                JSONObject job = json_array.getJSONObject(idx);
                String type_elem = job.getString("type");
                String name_elem = job.getString("name");
                if (type_elem.equals(type)){
                    type_list.add(name_elem);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return type_list;
    }

    public String picked(ArrayList<String> sb){
        Random random = new Random();
        int random_num = random.nextInt(sb.size());
        return sb.get(random_num);
    }
    public String now_date(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(today);
    }

}
