package com.example.test.sort;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/27
 * @Time: 15:10
 * I am a Code Man -_-!
 */
public class Sort2 {

    /**
     * 设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     *
     * @param a
     * @param n
     */
    public static void sort(int[] a, int n) {
        int j, k = n;
        boolean flag = true; //发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
        while (flag) {
            flag = false; //每次开始排序前，都设置flag为未排序过
            for (j = 0; j < k; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    //表示交换过数据;
                    flag = true;
                }
            }
            k--;//减小一次排序的尾边界
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        Sort2.sort(arr,arr.length-1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
