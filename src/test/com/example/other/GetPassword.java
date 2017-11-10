package test.com.example.other;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * Created by lenovo on 2017/6/12.
 */
public class GetPassword {
    public static void main(String[] args) {
        String  password="M9LStyQaUu75U7f4sU/ydcHoY8MdkC28691GgSVIbvPXnkZD7N4OB3oSmNb3tm1FwbKIKg3Y0Z/KqlB6zdCRWg==";
        String publicKey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMDnZZbtRsZJ5AVTberdjiubDHkulnmeKiOIN5FkQjopQGhtWamRMUsv8E9sZtwILSmFkhm6X6QxxKOFALgkvn0CAwEAAQ==";

        try{
            String decryptword= ConfigTools.decrypt(publicKey,password);
            System.out.println(decryptword);
        }catch (Exception e){
        e.printStackTrace();
    }

} }
