package com.wldst.ruder.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * 日期工具
 * 
 * 
 * @author liuqiang
 * @date 2020年7月1日 下午3:21:54
 * @version V1.0
 * @return
 */
public class DateTool {
    /**
     * 
     * 
     * @param pattern
     * @param date
     * @return
     * @author liuqiang
     * @date 2020年7月1日
     */
    public static String format(Date date, String pattern) {
	if (date == null)
	    throw new IllegalArgumentException("date is null");
	if (pattern == null)
	    throw new IllegalArgumentException("pattern is null");
	SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.CHINA);
	TimeZone GMT = TimeZone.getTimeZone("GMT+8");
	formatter.setTimeZone(GMT);
	return formatter.format(date);
    }

    public static String now() {
	return format(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss");
    }
    public static Long nowLong() {
	return Calendar.getInstance().getTime().getTime();
    }

    /**
     * datetime({ year:1984, month:10, day:11, hour:12, minute:31, second:14,
     * millisecond: 123, microsecond: 456, nanosecond: 789 })
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String neo4jDateTime(Date date) {
	if (date == null)
	    throw new IllegalArgumentException("date is null");
	Calendar instance = Calendar.getInstance();
	instance.setTime(date);
	return "{ year:" + instance.get(Calendar.YEAR) + ", month:" + (instance.get(Calendar.MONTH)+1) + ", day:"
		+ instance.get(Calendar.DAY_OF_MONTH) + ", hour:" + instance.get(Calendar.HOUR_OF_DAY) + ", minute:"
		+ instance.get(Calendar.MINUTE) + ", second:" + instance.get(Calendar.SECOND) + "}";
    }
    
    public static String neo4jDate(Date date) {
	if (date == null)
	    throw new IllegalArgumentException("date is null");
	Calendar instance = Calendar.getInstance();
	instance.setTime(date);
	return "{ year:" + instance.get(Calendar.YEAR) + ", month:" + (instance.get(Calendar.MONTH)+1) + ", day:"
		+ instance.get(Calendar.DAY_OF_MONTH) + "}";
    }

    public static String neo4jDate(String date) {
	return neo4jDate(strToDateLong(date));
    }

    public static Date strToDateLong(String strDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ParsePosition pos = new ParsePosition(0);
	Date strtodate = formatter.parse(strDate, pos);
	return strtodate;
    }
    
    public static Long dateStrToLong(String strDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ParsePosition pos = new ParsePosition(0);
	if(strDate.length()<5) {
	    return Calendar.getInstance().getTimeInMillis();
	}
	Date strtodate = formatter.parse(strDate, pos);
	if(strtodate==null) {
	    return null;
	}
	return strtodate.getTime();
    }
    
    public static Long dateStrShortToLong(String strDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	ParsePosition pos = new ParsePosition(0);
	if(strDate.length()<5) {
	    return Calendar.getInstance().getTimeInMillis();
	}
	Date strtodate = formatter.parse(strDate, pos);
	if(strtodate==null) {
	    return null;
	}
	return strtodate.getTime();
    }
    
    public static String dateStr(Long strDate) {
	Calendar instance = Calendar.getInstance();
	instance.setTimeInMillis(strDate);
	return format(instance.getTime(), "yyyy-MM-dd HH:mm:ss");
	
    }
    
    public static void replaceDateTime2Long(Map<String, Object> priMap) {
	Object start = priMap.get("startTime");
	if(priMap.containsKey("startTime")&&start!=null&&!start.equals("")) {
	    String valueOf = String.valueOf(start);
	    if(valueOf.trim().length()==10) {
		priMap.put("startTime", dateStrShortToLong(valueOf));
	    }else {
		priMap.put("startTime", dateStrToLong(valueOf));
	    }
	    
	}
	Object end = priMap.get("endTime");
	if(priMap.containsKey("endTime")&&end!=null&&!end.equals("")) {
	    String valueOf = String.valueOf(end);
	    if(valueOf.trim().length()==10) {
		priMap.put("endTime", dateStrShortToLong(valueOf));
	    }else {
		priMap.put("endTime", dateStrToLong(valueOf));
	    }
	}	
    }
    
    public static void replaceTimeLong2DateStr(Map<String, Object> priMap) {
	Object start = priMap.get("startTime");
	if(priMap.containsKey("startTime")&&start!=null&&!start.equals("")&&String.valueOf(start).indexOf("-")<0) {
	    priMap.put("startTime", dateStr(MapTool.longValue(priMap, "startTime")));
	}
	Object end = priMap.get("endTime");
	if(priMap.containsKey("endTime")&&end!=null&&!end.equals("")&&String.valueOf(end).indexOf("-")<0) {
	    priMap.put("endTime", dateStr(MapTool.longValue(priMap,"endTime")));
	}	
    }
    public static boolean over30m(Long longValue) {
     	long l = nowLong()-longValue;
	return l>1000*30*60;
    }

}
