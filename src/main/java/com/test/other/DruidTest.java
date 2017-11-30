package com.test.other;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by lenovo on 2017/6/12.
 */
@SuppressWarnings("all")
public class DruidTest extends DruidDataSource {
    @Override
    public  void setUsername(String username) {
        try {
            username = ConfigTools.decrypt(username);
            System.out.println(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        super.setUsername(username);
    }
}