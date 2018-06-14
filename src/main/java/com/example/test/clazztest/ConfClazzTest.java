package com.example.test.clazztest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/14
 * @Time: 10:34
 * I am a Code Man -_-!
 */
public class ConfClazzTest {

    public static void main(String[] args) {
        try{
            //通过反射获取Class对象
            Class stuClass = Class.forName(getValue("className"));//"com.example.test.clazztest.Student"
            //2获取show()方法
            Method m = stuClass.getMethod(getValue("methodName"));//show
            //3.调用show()方法
            m.invoke(stuClass.getConstructor().newInstance());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        //root找到根目录的路径，这样获取路径是因为java运行时相对路径报错
        String root = System.getProperty("user.dir");
        String filePath = root+File.separator+"src/main/resources/conf/pro.txt";
        System.out.println(filePath);
        FileReader in = new FileReader(filePath);//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
