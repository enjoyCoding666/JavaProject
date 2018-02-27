package com.collection;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by lenovo on  二月
 */
public class MapOperation {

    public static void ergodicMap(Map<Object,Object> map){
        for(Map.Entry entry : map.entrySet()) {
            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
        }
    }

    public static String mapToString(Map<Object,Object> map)
    {
        SortedMap<Object,Object> sortedMap = new TreeMap<Object,Object>(map);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry entry : sortedMap.entrySet()) {
            sb.append( "key:"+ entry.getKey() +"  value:"+entry.getValue()+"\n");
        }
        return sb.length() == 0 ? "" : sb.toString();
    }



}
