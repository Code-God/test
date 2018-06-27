package com.example.test.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/27
 * @Time: 15:57
 * I am a Code Man -_-!
 */
public class RandomArr {


    //将其插入进数组，插入的数字不能重复
    public static void main(String[] args) {
        int n = 100;//取值范围终点
        int[] array = new int[n];
        Random r = new Random(100);
        array[0] = 0;
        //循环遍历
        for (int i = 0; i < 100; i++) {
            array[i] = r.nextInt(100) + 1;
            //array[i] = (int)(Math.random()*100+1);
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(array);
        for (int i = 0; i < 100; i++) {
            //打印遍历
            System.out.print(array[i] + "  ");
        }
    }
}
