package com.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Properties;


/**
 * 获取工程外的properties文件。
 * @author lenovo
 *
 */
@Slf4j
public class PropertyUtils {

    private static Properties props;
    public static final String PATH_PROPERTIES="E:\\Test\\path.properties";

    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        log.info("开始加载"+PATH_PROPERTIES+"的properties文件内容.......");
        props  = new Properties();
        InputStream in = null;


        try {
            in =new BufferedInputStream(new FileInputStream(PATH_PROPERTIES))     ;
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

    public static String getProperty( String key){
        String value=null;
        if(null == props ) {
            loadProps();
        }
        return props.getProperty(key);
    }


}
