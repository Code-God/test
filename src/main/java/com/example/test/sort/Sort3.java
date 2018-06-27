package com.example.test.sort;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/27
 * @Time: 15:21
 * I am a Code Man -_-!
 */
public class Sort3 {

    /*再进一步做优化。比如，现在有一个包含1000个数的数组，仅前面100个无序，后面900个都已排好序且都大于前面100个数字，
    那么在第一趟遍历后，最后发生交换的位置必定小于100，且这个位置之后的数据必定已经有序了，也就是这个位置以后的数据不需要再排序了，
    于是记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。如果是对于上面的冒泡排序算法2来说，虽然也只排序100次，
    但是前面的100次排序每次都要对后面的900个数据进行比较，而对于现在的排序算法3，只需要有一次比较后面的900个数据，
    之后就会设置尾边界，保证后面的900个数据不再被排序。*/

    public static void sort(int[] a, int n) {
        int j, k;
        int flag = n;//flag来记录最后交换的位置，也就是排序的尾边界
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (j = 0; j < k; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    //表示交换过数据;
                    flag = j; //记录最新的尾边界.
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        Sort3.sort(arr, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
