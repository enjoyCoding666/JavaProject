package com.bit;

/**
 * 位运算
 *
 *
 */
public class BitDemo {

    /**
     *
     *       &运算(与运算)：两个二进制操作数对应位同为1 结果位 才为1，其余情况为0；
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
    public static void andDemo() {
        int result = 8 & 7;
        System.out.println(result);

    }



    /**
     *      |运算 (或运算)：两个二进制操作数对应位只要有一个为1 结果位 就为1，其余情况为0；
     *      |运算 (或运算). 1|1=1,1|0=1,0|0=0
     *
     *      8 | 7 的运算步骤如下：
     *      0111
     *      1000
     *      结果:
     *      1111
     *
     *      1111转化为十进制是15，也就是说 8 | 7 = 15.
     */
    public static void orDemo() {
        int result = 8 | 7;
        System.out.println(result);

    }


    /**
     * 异或	a ^ b	：两个二进制操作数对应位，相同为0，相异为1
     *
     */
    public static void xorDemo() {
        int result = 5 ^ 10;
        System.out.println(result);

    }


    /**
     *  ~	取反	~a：二进制操作数 0的为1，1的为0
     *
     */
    public static void reverseDemo() {
        int result = ~5;
        System.out.println(result);
    }


    /**
     * 左移一位，相当于乘以2。
     *
     */
    public static void leftDemo() {
        int result = 7 << 1;
        System.out.println(result);
    }


    /**
     * 右移一位，相当于除以2。
     *
     */
    public static void rightDemo() {
        int result = 8 >> 1;
        System.out.println(result);
    }


}
