package com.base;


import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        scannerMore();
    }

    private static void scannerMore() {
        //输入输出，牛客网之类的平台会用到
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
