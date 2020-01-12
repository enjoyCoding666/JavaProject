package com.enumdemo;


public class StatusEnumDemo {
    public static void main(String[] args) {
        String type="1";
        String status= StatusEnum.getStatusByValues(type);
        System.out.println(String.format("类型%s对应的状态为%s",type,status));
    }

    /**
     * 不建议使用这样的写法。
     * 这种存在大量if，else的代码，可以使用枚举去处理。
     *
     * @param type
     * @return
     */
    public static String getStatus(String type) {
        String status;
        if ("1".equals(type)) {
            status="成功";
        } else if ("2".equals(type)) {
            status = "失败";
        } else if ("3".equals(type)) {
            status = "等待";
        } else {
            status="";
        }
        return status;
    }

    /**
     * 使用枚举常量
     *
     * @param type
     * @return
     */
    public static String getStatusByType(String type) {
        String status=null;
        if (StatusEnum.Success.getType().equals(type)) {
            status=StatusEnum.Success.getStatus();
        }
        return status;
    }


}
