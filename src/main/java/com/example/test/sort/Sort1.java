package com.example.test.sort;

/**
 * @Author: wuxiaobiao
 * @Description:   冒泡排序的第一种实现, 没有任何优化
 * @Date: Created in 2018/6/27
 * @Time: 14:54
 * I am a Code Man -_-!
 */
public class Sort1 {

    public static void sort(int[] a, int n) {
        for (int i = 0; i < n; i++) {  //表示n次排序过程。
            for (int j = 0; j < n - i; j++) {  //前面的数字大于后面的数字就交换
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        Sort1.sort(arr,arr.length-1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
