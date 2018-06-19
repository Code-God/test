package com.example.test.test1;

/**
 * @Author: wuxiaobiao
 * @Description: 移位运算
 * @Date: Created in 2018/6/19
 * @Time: 15:47
 * I am a Code Man -_-!
 */
public class Test {

    /**
     * 在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方
     * @param args
     */
    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        printInfo(number);
        //左移一位
        number = number << 1;
        printInfo(number);
        //右移一位
        number = number >> 1;
        printInfo(number);
        //无符号右移的规则只记住一点：忽略了符号位扩展，0补最高位  无符号右移运算符>>> 只是对32位和64位的值有意义
        number = number >>> 1;
        printInfo(number);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
