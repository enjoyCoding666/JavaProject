package com.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtil {
    private static  String propertiesFileName="jdbc.properties";
    private static final Logger logger = Logger.getLogger(PropertyUtil.class);
    private static Properties props= new Properties();
    static{
        logger.info("执行静态代码块loadProps()，保存在jvm中，避免多次执行。");
        loadProps();
    }

    synchronized static private void loadProps(){
        logger.info("开始加载properties文件内容.......");
//        props = new Properties();
        InputStream in = null;
        try {
//　　　　　　　<!--第一种，通过类加载器进行获取properties文件流，路径为相对路径-->
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(propertiesFileName);
//　　　　　　  <!--第二种，通过类进行获取properties文件流-->
            //in = PropertyUtil.class.getResourceAsStream("propertiesFileName");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}