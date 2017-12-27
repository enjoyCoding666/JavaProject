package com.enumDemo;

public enum Status {
    Success("报竣成功",9),Failure("报竣失败",-1),Wait("等待报竣",23),ProvinceFailure("省应答失败",22);

    private String status;
    private int number;

    Status(String status, int number) {
        this.status = status;
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}