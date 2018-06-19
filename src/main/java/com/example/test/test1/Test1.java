package com.example.test.test1;

/**
 * @Author: wuxiaobiao
 * @Description: 100以内质数运算
 * @Date: Created in 2018/6/19
 * @Time: 16:13
 * I am a Code Man -_-!
 */
public class Test1 {

    public static int[] getPrimeNumber(int n){
        int[] priArr=new int[n];
        for(int i=2;i<n;i++){
            boolean isPrime=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                priArr[i]=i;
            }
        }
        return priArr;
    }
    public static void main(String[] args) {
        int[] retArr=getPrimeNumber(100);
        int num = 0;
        for(int i=0;i<retArr.length;i++){
            if(retArr[i] !=0){
                num++;
                System.out.println(retArr[i]);
            }
        }
        System.out.println("当前质数为：=》"+num);
    }
}
