package com.example.test.clazztest;

/**
 * @Author: wuxiaobiao
 * @Description:  获取Class对象的三种方式
 * @Date: Created in 2018/6/13
 * @Time: 18:05
 * I am a Code Man -_-!
 */
public class ClassTest {

    public static void main(String[] args) {
       // 三种方式常用第三种，第一种对象都有了还要反射干什么。第二种需要导入类的包，依赖太强，不导包就抛编译错误。一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。

        //第一种方式获取Class对象
        Student stu1 = new Student(); //这一new 产生一个Student对象，一个Class对象。无论new多少次有且只有一个class对象，在运行期间，一个类，只有一个Class对象产生。
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("com.example.test.clazztest.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
