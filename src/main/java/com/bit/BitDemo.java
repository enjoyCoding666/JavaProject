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
     *
     *       1是0001，其他数跟 1做与运算，都只看最后一位即可，其他的都是0。
     *       8&1,就是二进制1000和0001的与运算，结果得到 0000
     *       7&1,就是二进制0111和0001的与运算，结果得到 0001。
     *       某一个数x， x & 1 可以得到 x 除以 2 的余数。也就是说，可以用 x & 1 来判断奇偶数。
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
