package com.json;

import com.bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lenovo on  三月
 */
public class JsonDemo {

    public static void jsonToObject(){
        String jsonString ="{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"}";
        JSONObject json = JSONObject.fromObject(jsonString);
        User user = new User();
        user.setName(json.getString("name"));
        user.setPassword(json.getString("password"));
        user.setEmail(json.getString("email"));
        System.out.println(user.toString());
    }

    public static void jsonArrayToObject(){
        String json = "[{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"},{\"name\":\"lisi\",\"password\":\"lisi123\",\"email\":\"1435123@qq.com\"} ] ";
        JSONArray jsonArray=JSONArray.fromObject(json);
        ArrayList<User> users=new ArrayList<>();
        for( int i=0 ;i < jsonArray.size() ; i++) {
            User user=new User();
            user.setName( jsonArray.getJSONObject(i).getString("name") );
            user.setEmail( jsonArray.getJSONObject(i).getString("email") );
            user.setPassword(  jsonArray.getJSONObject(i).getString("password") );
            users.add(user);
        }
        for(User user : users) {
            System.out.println(user.toString());
        }




    }

}
