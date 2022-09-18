package com.string;

import java.util.Scanner;

public class SpecialString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(isTarget(scanner.next()));
        }
    }

    /**
     * 判断是否回文字符串
     *
     */
    public static boolean isTarget(String str) {
        if (str==null) {
            return false;
        }
        boolean isTar = true;
        //双指针
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length-1-i)) {
                return false;
            }
        }
        return isTar;
    }

}
