package com.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;


/**
 * 获取工程外的properties文件。
 * @author lenovo
 *
 */
public class PropertyUtils {
    private static final Logger  logger = Logger.getLogger(PropertyUtil.class);
    private static Properties props;
    public static final String PATH_PROPERTIES="E:\\Test\\path.properties";

    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        logger.info("开始加载"+PATH_PROPERTIES+"的properties文件内容.......");
        props  = new Properties();
        InputStream in = null;


        try {
            in =new BufferedInputStream(new FileInputStream(PATH_PROPERTIES))     ;
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

    public static String getProperty( String key){
        String value=null;
        if(null == props ) {
            loadProps();
        }
        return props.getProperty(key);
    }


}
