package com.object;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.SerializationUtils;

/**
 * @Auther: Administrator
 * @Date: 2019\7\5 0005 0:59
 * @Description:
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        JSONObject paramJson= new JSONObject();
        paramJson.put("age",26);
        paramJson.put("name","lin");
        JSONObject cloneJson=  (JSONObject)SerializationUtils.clone(paramJson);
        cloneJson.put("age",27);
        System.out.println("paramJson:"+paramJson.toString());
        System.out.println("cloneJson:"+cloneJson.toString());
    }
}