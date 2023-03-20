package com.util;


import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取项目内指定的properties文件
 */
@Slf4j
public class PropertyUtil {
    private static final String PROPERTIES_FILE_NAME ="jdbc.properties";

    private static Properties props= new Properties();
    static{
        log.info("执行静态代码块loadProps()，保存在jvm中，避免多次执行。");
        loadProps();
    }

    synchronized static private void loadProps(){
        log.info("开始加载properties文件内容.......");
//        props = new Properties();
        InputStream in = null;
        try {
//　　　　　　　<!--第一种，通过类加载器进行获取properties文件流，路径为相对路径-->
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
//　　　　　　  <!--第二种，通过类进行获取properties文件流-->
            //in = PropertyUtil.class.getResourceAsStream("propertiesFileName");
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("properties文件未找到");
        } catch (IOException e) {
            log.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("properties文件流关闭出现异常");
            }
        }
        log.info("加载properties文件内容完成...........");
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