package com.enumdemo;

public enum StatusEnum {
    Success("1", "成功"),
    Failure("2", "失败"),
    Wait("3", "等待"),

    ;

    private String status;
    private String type;

    StatusEnum(String type, String status) {
        this.status = status;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 遍历枚举常量，代替大量的if，else代码。
     *
     * @param type
     * @return
     */
    public static String getStatusByValues(String type) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getType().equals(type)) {
                return statusEnum.getStatus();
            }
        }
        return "";
    }
}