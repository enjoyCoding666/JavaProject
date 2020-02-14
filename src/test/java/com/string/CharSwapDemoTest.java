package com.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: lenovo
 * @Date: 2020/2/1 21:46
 * @Description:
 */
class CharSwapDemoTest {

    @Test
    void swapCharInString() {
        String s = CharSwapDemo.swapCharInString("abcd");
        System.out.println(s);
    }

    @Test
    void reveserString() {
        CharSwapDemo.reveserString();

    }
}