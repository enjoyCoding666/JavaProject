package com.object;

import net.sf.json.JSONObject;

/**
 * @Auther: Administrator
 * @Date: 2019\7\5 0005 0:45
 * @Description:
 */
public class CloneTest {
    public static void main(String[] args)  {
        JSONObject paramJson= new JSONObject();
        paramJson.put("age",26);
        paramJson.put("name","lin");
        JSONObject cloneJson= paramJson;
        cloneJson.put("age",27);
        System.out.println("paramJson:"+paramJson.toString());
        System.out.println("cloneJson:"+cloneJson.toString());
    }
}