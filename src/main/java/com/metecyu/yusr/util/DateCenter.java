package com.metecyu.yusr.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;


public class DateCenter {
	private static final Logger log = Logger.getLogger(DateCenter.class);
	
	String _________字符串转日期____________= "";
	/**
	 * String转为Date 转换不成功 返回日期1900-01-01 
	 * String格式 必须是 yyyy-MM-dd  
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static Date getDate(String str) throws Exception{
		
		Date outDate = new Date();
		try{
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			outDate = sf.parse(str);
			//sf.getCalendar().MONTH;
			//  System.out.println(sf.getCalendar().YEAR);
			sf.getCalendar().get(sf.getCalendar().YEAR);
			return outDate;
		}catch(Exception ex){
			
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			try {
				outDate = sf.parse("1900-01-01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("出错：",e);
			}
			System.out.println(ex);
		}
		return outDate;
	}
	/**
	 * String转为Date 转换不成功 会抛出异常
	 * String格式 必须是 yyyy-MM-dd  
	 * @param str
	 * @return
	 */
	public static Date getDateThrows(String str) throws ParseException{
		Date outDate = new Date();
	
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		outDate = sf.parse(str);
		//sf.getCalendar().MONTH;
		//  System.out.println(sf.getCalendar().YEAR);
		sf.getCalendar().get(sf.getCalendar().YEAR);		
		return outDate;
	}
	/**
	 * 如果格式不正确 返回null 
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static Date getDateNull(String str) throws Exception{
		Date outDate = null;
	
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			outDate = sf.parse(str);
		} catch (ParseException e) {
			outDate = null;
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(str + " 日期不符合 yyyy-MM-dd 格式" );
			throw new Exception("出错：",e);
		}
		//sf.getCalendar().MONTH;
		//  System.out.println(sf.getCalendar().YEAR);
		// sf.getCalendar().get(sf.getCalendar().YEAR);		
		return outDate;
	}
	
	
	String _________获得日期部分属性____________= "";
	
	/**
	 * 获得日期的年份
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getYear(String str) throws Exception{
		String returnStr ="";
			Date outDate = new Date();
		try{
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			outDate = sf.parse(str);
			//sf.getCalendar().MONTH;
			
			returnStr = ""+sf.getCalendar().get(Calendar.YEAR);
			
		}catch(Exception ex){
			System.out.println(ex);
			throw new Exception("出错：",ex);
		}
		return returnStr;
		
	}
	/**
	 * 获得日期的月份
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getMonth(String str) throws Exception{
		String returnStr ="";
			Date outDate = new Date();
		try{
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			outDate = sf.parse(str);
			//sf.getCalendar().MONTH;
			int month = sf.getCalendar().get(Calendar.MONTH)+1;
			returnStr = ""+month;
			
		}catch(Exception ex){
			System.out.println(ex);
			throw new Exception("出错：",ex);
		}
		return returnStr;
		
	}
	/**
	 * 获得日期的天数
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getDays(String str) throws Exception{
		String returnStr ="";
			Date outDate = new Date();
		try{
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			outDate = sf.parse(str);
			//sf.getCalendar().MONTH;
			int days = sf.getCalendar().get(Calendar.DAY_OF_MONTH);
			returnStr = ""+days;
			
		}catch(Exception ex){
			System.out.println(ex);
			throw new Exception("出错：",ex);
		}
		return returnStr;
		
	}
	

	/**
	 * 获得中文的 星期X
	 * @param str
	 * @return
	 */
	public static String getDayInWeek_Xingqi(Date _date){
		String str = "";
		int days = _date.getDay();
		if(days==0){
			str= "星期天";
		}else if(days==1){
			str= "星期一";
		}else if(days==2){
			str= "星期二";
		}else if(days==3){
			str= "星期三";
		}else if(days==4){
			str= "星期四";
		}else if(days==5){
			str= "星期五";
		}else if(days==6){
			str= "星期六";
		}
		return str;
		
		
	}
	/**
	 * 获得中文的 周X
	 * @param str
	 * @return
	 */
	public static String getDayInWeek_Zhou(Date _date){
		String str = "";
		int days = _date.getDay();
		if(days==0){
			str= "周日";
		}else if(days==1){
			str= "周一";
		}else if(days==2){
			str= "周二";
		}else if(days==3){
			str= "周三";
		}else if(days==4){
			str= "周四";
		}else if(days==5){
			str= "周五";
		}else if(days==6){
			str= "周六";
		}
		return str;		
	}
	
	
	String _________日期转字符串____________= "";
	/**
	 * 日期 转 Strng
	 * 字符串格式 yyyy-MM-dd
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getDateStr(Date _date) throws Exception{
		String strDate ="";
		try{
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			strDate = sf.format(_date);			
		}catch(Exception ex){
			System.out.println(ex);
			throw new Exception("出错：",ex);
		}
		//System.out.println("xxxxxxx" + strDate);
		return strDate;
		
	}
	
	
	String _________月份__________ ="";
	/**
	 * 获得本月的第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDateInMonth(Date date){
		Date outDate = null;
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sf.format(date);
		sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 1);
		
		outDate =sf.getCalendar().getTime();
		return outDate;
		
	}
	/**
	 * 获得本月的最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDateInMonth(Date date){
		
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sf.format(date);
		// sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 1);
		// 月份+1 日期 -1 获得 本月最后一天的效果
		sf.getCalendar().add(sf.getCalendar().MONTH, 1);
		sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 1);
		//  
		sf.getCalendar().add(sf.getCalendar().DAY_OF_MONTH, -1);
		Date outDate =sf.getCalendar().getTime();
		return outDate;
		
	}
	/**
	 * 添加月份 
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date addMonth(Date date,int i){
		
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sf.format(date);
		// sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 1);
		// 月份+1 日期 -1 获得 本月最后一天的效果
		sf.getCalendar().add(sf.getCalendar().MONTH, i);
		
		Date outDate =sf.getCalendar().getTime();
		return outDate;
		
	}
	
	
	public static long compareDate(Date startDate,Date endDate){
		long totalDate =0l;
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		long timestart = c.getTimeInMillis();
		
		c.setTime(endDate);
		long timeend = c.getTimeInMillis();
		
		totalDate = (timeend - timestart)/(1000*60*60*24);
		return totalDate;
		
	}
	String _________年份__________ ="";
	/**
	 * 获得本年的最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDateInYear(Date date){
		
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sf.format(date);
		sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 31);
		sf.getCalendar().set(sf.getCalendar().MONTH, 11);
		Date outDate =sf.getCalendar().getTime();
		return outDate;
		
	}
	/**
	 * 获得本年的第一天
	 * @param date
	 * @return
	 */
	public static Date getFristDateInYear(Date date){
		
		java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sf.format(date);
		sf.getCalendar().set(sf.getCalendar().DAY_OF_MONTH, 1);
		sf.getCalendar().set(sf.getCalendar().MONTH, 0);
		Date outDate =sf.getCalendar().getTime();
		return outDate;
		
	}
	
	
	
}
