package com.string;

/**
 * Created by lenovo on  十月
 */
public class CompareToTest {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aad";
        String s3 = "aadfg";
        String s4 = "1dfg";
        String s5 = "az";
        System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1)
        System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3)
        System.out.println( s1.compareTo(s4) ); // 48 ("a"的编码是97,"1"的的编码是49,所以返回48)
        System.out.println( s1.compareTo(s5) ); // -2 ("a"的编码是97,"z"的编码是122,所以返回25)
    }
}
