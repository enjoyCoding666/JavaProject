package com.collection;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by lenovo on  二月
 */
public class MapOperation {

    public static String mapToString(Map<String, String> map)
    {
        SortedMap<String, String> sortedMap = new TreeMap<String, String>(map);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println( "key:"+ entry.getKey() +"   value:"+entry.getValue());
        }

        return sb.length() == 0 ? "" : sb.toString();
    }
}
