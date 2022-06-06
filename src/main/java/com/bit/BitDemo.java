package com.bit;

/**
 * 位运算
 *
 *
 */
public class BitDemo {

    /**
     *

     *       &运算(与运算)中1&1=1,1&0=0,0&0=0

     *       8 & 7 的运算步骤如下：
     *       8的二进制是1000，7的二进制是0111
     *
     *       1000
     *       0111
     *       结果：
     *       0000
     *
     *       把8的每一位都跟7的每一位进行运算，最高位 1&0=0， 后面的第二位是 0&1=0，依此类推。结果为 0000.
     *
     *       所以可以得出0000，故输出的是0。
     *
     */
    public static void andDemo(int num1, int num2) {
        int result = num1 & num2;
        System.out.println(result);

    }



    /**
     *      |运算 (或运算). 1|1=1,1|0=1,0|0=0
     *
     *      8 | 7 的运算步骤如下：
     *      0111
     *      1000
     *      结果:
     *      1111
     *
     */
    public static void orDemo(int num1, int num2) {
        int result = num1 | num2;
        System.out.println(result);

    }


    /**
     * 异或	a ^ b	相同为0，相异为1
     *
     * @param num1
     * @param num2
     */
    public static void xorDemo(int num1, int num2) {
        int result = num1 ^ num2;
        System.out.println(result);

    }


    /**
     *  ~	取反	~a	0的为1，1的为0
     *
     */
    public static void reverseDemo(int num) {
        int result = ~num;
        System.out.println(result);
    }


    /**
     * 左移一位，相当于乘以2。
     *
     */
    public static void leftDemo(int num) {
        int result = num << 1;
        System.out.println(result);
    }


    /**
     * 右移一位，相当于除以2。
     *
     */
    public static void rightDemo(int num) {
        int result = num >> 1;
        System.out.println(result);
    }


}
