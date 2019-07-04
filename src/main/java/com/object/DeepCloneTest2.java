package com.object;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: Administrator
 * @Date: 2019\7\5 0005 0:57
 * @Description:
 */
public class DeepCloneTest2 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        JSONObject paramJson= new JSONObject();
        paramJson.put("age",26);
        paramJson.put("name","lin");
        JSONObject cloneJson= new JSONObject();
        BeanUtils.copyProperties(cloneJson,paramJson);
        cloneJson.put("test",27);
        System.out.println("paramJson:"+paramJson.toString());
        System.out.println("cloneJson:"+cloneJson.toString());
    }
}