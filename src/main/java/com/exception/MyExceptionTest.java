package com.exception;

import org.apache.commons.lang.StringUtils;

public class MyExceptionTest {
     public static void main(String[] args) throws MyException {
          String[] strArr={"str1","str2","str3","","str5"};
          for(String str: strArr) {
               if( !StringUtils.isEmpty(str)) {
                    System.out.println(str);
               }else {
                    throw  new MyException("字符串不可为空");
               }

          }
     }
}
