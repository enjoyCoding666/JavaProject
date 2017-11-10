package com.example.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	//声明日期格式化操作对象，直接对new Date（）进行实例化
	private SimpleDateFormat sdf=null;
	public String getDate(){
		this.sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return this.sdf.format(new Date());
	}

	public String getDateComplete() {

		this.sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return this.sdf.format(new Date());
	}
}
