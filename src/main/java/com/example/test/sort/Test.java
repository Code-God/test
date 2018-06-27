package com.example.test.sort;

import lombok.Data;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/27
 * @Time: 15:39
 * I am a Code Man -_-!
 */
@Data
public class Test {

    private String name;
    private Integer orderOne;
    private Integer orderTwo;

    public Test(String name, Integer orderOne, Integer orderTwo) {
        this.name = name;
        this.orderOne = orderOne;
        this.orderTwo = orderTwo;
    }
}
