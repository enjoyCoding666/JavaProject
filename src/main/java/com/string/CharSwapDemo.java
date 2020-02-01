package com.string;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * @Author: lenovo
 * @Date: 2020/2/1 21:39
 * @Description:
 */
public class CharSwapDemo {

    public static String swapCharInString(String str) {
        if (str == null) {
            return null;
        }
        //注意，要给StringBuilder初始化，否则后续设置字符会报错"数组越界"
        StringBuilder sb = new StringBuilder(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            sb.setCharAt(i, str.charAt(length - i - 1));
        }
        return sb.toString();
    }

}
