package test.com.bit;

import com.concurrent.ConcurrentHashMapDemo;

import java.util.concurrent.ConcurrentHashMap;

public class PutValTest {
    public static void main(String[] args) {

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("abcd", "cccc");
        System.out.println(concurrentHashMap.get("abcd"));

    }
}
