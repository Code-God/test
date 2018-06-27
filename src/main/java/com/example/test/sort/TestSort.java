package com.example.test.sort;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/27
 * @Time: 15:40
 * I am a Code Man -_-!
 */
public class TestSort {

    public static void testOrderBeansList(List<Test> list) {
        try {
            //根据集合中的某个字段,对集合排序__特别适用于从mongoDB中从多层嵌套取出的数据,方便对其排序
            ComparatorChain chain = new ComparatorChain();
            chain.addComparator(new BeanComparator("orderOne"), false); //true降序,false升序
            chain.addComparator(new BeanComparator("orderTwo"), true);  //true降序,false升序
            Collections.sort(list, chain);//List<T> 或者是其他的集合
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //测试用集合
        List<Test> list = new ArrayList<>();
        //添加十个测试数据
        for (int i = 0; i < 10; i++) {
            Random random = new Random();// 定义随机类
            int num1 = random.nextInt(10);// 返回[0,10)集合中的随机整数,注意不包括10
            int num2 = random.nextInt(10);// 返回[0,10)集合中的随机整数,注意不包括10
            Test t = new Test("name" + num1, num1, num2);
            list.add(t);
        }
        testOrderBeansList(list);
        for (Test r: list) {
            System.out.println(r.toString());
        }
    }
}
