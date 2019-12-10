package com.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Auther: Administrator
 * @Date: 2019\7\10 0010 23:31
 * @Description:
 */
public class JsonTest {
    public static void main(String[] args) {
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","lin");
        jsonObject.put("age",100);
        jsonArray.add(jsonObject);
//        for(int i=0;i<jsonArray.size();i++){
//            JSONObject jsonobject=jsonArray.getJSONObject(i);
//            System.out.println(jsonobject.getString("name"));
//        }
        for (Object user:jsonArray){
            String name= ((JSONObject) user).getString("name");
            System.out.println(name);
        }


    }
}
