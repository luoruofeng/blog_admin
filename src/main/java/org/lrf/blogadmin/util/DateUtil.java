package org.lrf.blogadmin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	public String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		return df.format(new Date());
	}

}
