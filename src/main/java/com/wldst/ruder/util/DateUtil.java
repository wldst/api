package com.wldst.ruder.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(currentTime);
	ParsePosition pos = new ParsePosition(8);
	Date currentTime_2 = formatter.parse(dateString, pos);
	return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = formatter.format(currentTime);
	ParsePosition pos = new ParsePosition(8);
	Date currentTime_2 = formatter.parse(dateString, pos);
	return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public static String getTimeShort() {
	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	Date currentTime = new Date();
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ParsePosition pos = new ParsePosition(0);
	Date strtodate = formatter.parse(strDate, pos);
	return strtodate;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String dateToStrLong(java.util.Date dateDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(dateDate);
	return dateString;
    }

    public static String dateTimeString(Long dateDate) {
	Date d = new Date(dateDate);
	return dateToStrLong(d);
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @param k
     * @return
     */
    public static String dateToStr(java.util.Date dateDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = formatter.format(dateDate);
	return dateString;
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	ParsePosition pos = new ParsePosition(0);
	Date strtodate = formatter.parse(strDate, pos);
	return strtodate;
    }

    /**
     * 得到现在时间
     *
     * @return
     */
    public static Date getNow() {
	Date currentTime = new Date();
	return currentTime;
    }

    /**
     * 提取一个月中的最后一天
     *
     * @param day
     * @return
     */
    public static Date getLastDate(long day) {
	Date date = new Date();
	long date_3_hm = date.getTime() - 3600000 * 34 * day;
	Date date_3_hm_date = new Date(date_3_hm);
	return date_3_hm_date;
    }

    /**
     * 得到现在时间
     *
     * @return 字符串 yyyyMMdd HHmmss
     */
    public static String getStringToday() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    public static String nowTime() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    public static String nowTime(String pattern) {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    public static String nowDateTime() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    /**
     * 得到现在小时
     */
    public static String getHour() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(currentTime);
	String hour;
	hour = dateString.substring(11, 13);
	return hour;
    }

    /**
     * 得到现在分钟
     *
     * @return
     */
    public static String getTime() {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(currentTime);
	String min;
	min = dateString.substring(14, 16);
	return min;
    }

    /**
     * 获取当年
     * 
     * @return
     */
    public static int getCurrentYear() {
	Calendar c = Calendar.getInstance();
	return c.get(Calendar.YEAR);
    }

    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat yyyyMMddhhmmss
     * @return
     */
    public static String getUserDate(String sformat) {
	Date currentTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat(sformat);
	String dateString = formatter.format(currentTime);
	return dateString;
    }

    /**
     * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
     */
    public static String getTwoHour(String st1, String st2) {
	String[] kk = null;
	String[] jj = null;
	kk = st1.split(":");
	jj = st2.split(":");
	if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
	    return "0";
	else {
	    double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
	    double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
	    if ((y - u) > 0)
		return y - u + "";
	    else
		return "0";
	}
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	long day = 0;
	try {
	    java.util.Date date = myFormatter.parse(sj1);
	    java.util.Date mydate = myFormatter.parse(sj2);
	    day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	} catch (Exception e) {
	    return "";
	}
	return day + "";
    }

    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     */
    public static String getPreTime(String sj1, String jj) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String mydate1 = "";
	try {
	    Date date1 = format.parse(sj1);
	    long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
	    date1.setTime(Time * 1000);
	    mydate1 = format.format(date1);
	} catch (Exception e) {
	}
	return mydate1;
    }

    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static String getNextDay(String nowdate, String delay) {
	try {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String mdate = "";
	    Date d = strToDate(nowdate);
	    long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
	    d.setTime(myTime * 1000);
	    mdate = format.format(d);
	    return mdate;
	} catch (Exception e) {
	    return "";
	}
    }

    /**
     * 判断是否润年
     *
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(String ddate) {

	/**
	 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	 * 3.能被4整除同时能被100整除则不是闰年
	 */
	Date d = strToDate(ddate);
	GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	gc.setTime(d);
	int year = gc.get(Calendar.YEAR);
	if ((year % 400) == 0)
	    return true;
	else if ((year % 4) == 0) {
	    if ((year % 100) == 0)
		return false;
	    else
		return true;
	} else
	    return false;
    }

    /**
     * 返回美国时间格式 26 Apr 2006
     *
     * @param str
     * @return
     */
    public static String getEDate(String str) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	ParsePosition pos = new ParsePosition(0);
	Date strtodate = formatter.parse(str, pos);
	String j = strtodate.toString();
	String[] k = j.split(" ");
	return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }

    /**
     * 获取一个月的最后一天
     *
     * @param dat
     * @return
     */
    public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
	String str = dat.substring(0, 8);
	String month = dat.substring(5, 7);
	int mon = Integer.parseInt(month);
	if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
	    str += "31";
	} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
	    str += "30";
	} else {
	    if (isLeapYear(dat)) {
		str += "29";
	    } else {
		str += "28";
	    }
	}
	return str;
    }

    /**
     * 判断二个时间是否在同一个周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal1.setTime(date1);
	cal2.setTime(date2);
	int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
	if (0 == subYear) {
	    if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
		return true;
	} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
	    // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
	    if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
		return true;
	} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
	    if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
		return true;
	}
	return false;
    }

    /**
     * 产生周序列,即得到当前时间所在的年度是第几周
     *
     * @return
     */
    public static String getSeqWeek() {
	Calendar c = Calendar.getInstance(Locale.CHINA);
	String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
	if (week.length() == 1)
	    week = "0" + week;
	String year = Integer.toString(c.get(Calendar.YEAR));
	return year + week;
    }

    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     *
     * @param sdate
     * @param num
     * @return
     */
    public static String getWeek(String sdate, String num) {
	// 再转换为时间
	Date dd = DateUtil.strToDate(sdate);
	Calendar c = Calendar.getInstance();
	c.setTime(dd);
	if (num.equals("1")) // 返回星期一所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	else if (num.equals("2")) // 返回星期二所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	else if (num.equals("3")) // 返回星期三所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
	else if (num.equals("4")) // 返回星期四所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	else if (num.equals("5")) // 返回星期五所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
	else if (num.equals("6")) // 返回星期六所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	else if (num.equals("0")) // 返回星期日所在的日期
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
	// 再转换为时间
	Date date = DateUtil.strToDate(sdate);
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	// int hour=c.get(Calendar.DAY_OF_WEEK);
	// hour中存的就是星期几了，其范围 1~7
	// 1=星期日 7=星期六，其他类推
	return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    public static String getWeekStr(String sdate) {
	String str = "";
	str = DateUtil.getWeek(sdate);
	if ("1".equals(str)) {
	    str = "星期日";
	} else if ("2".equals(str)) {
	    str = "星期一";
	} else if ("3".equals(str)) {
	    str = "星期二";
	} else if ("4".equals(str)) {
	    str = "星期三";
	} else if ("5".equals(str)) {
	    str = "星期四";
	} else if ("6".equals(str)) {
	    str = "星期五";
	} else if ("7".equals(str)) {
	    str = "星期六";
	}
	return str;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
	if (date1 == null || date1.equals(""))
	    return 0;
	if (date2 == null || date2.equals(""))
	    return 0;
	// 转换为标准时间
	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = null;
	java.util.Date mydate = null;
	try {
	    date = myFormatter.parse(date1);
	    mydate = myFormatter.parse(date2);
	} catch (Exception e) {
	}
	long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	return day;
    }

    /**
     * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
     * 此函数返回该日历第一行星期日所在的日期
     *
     * @param sdate
     * @return
     */
    public static String getNowMonth(String sdate) {
	// 取该时间所在月的一号
	sdate = sdate.substring(0, 8) + "01";

	// 得到这个月的1号是星期几
	Date date = DateUtil.strToDate(sdate);
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	int u = c.get(Calendar.DAY_OF_WEEK);
	String newday = DateUtil.getNextDay(sdate, (1 - u) + "");
	return newday;
    }

    /**
     * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
     *
     * @param k 表示是取几位随机数，可以自己定
     */

    public static String getNo(int k) {

	return getUserDate("yyyyMMddhhmmss") + getRandom(k);
    }

    /**
     * 返回一个随机数
     *
     * @param i
     * @return
     */
    public static String getRandom(int i) {
	Random jjj = new Random();
	// int suiJiShu = jjj.nextInt(9);
	if (i == 0)
	    return "";
	String jj = "";
	for (int k = 0; k < i; k++) {
	    jj = jj + jjj.nextInt(9);
	}
	return jj;
    }

    /**
     *
     * @param args
     */
    public static boolean RightDate(String date) {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	;
	if (date == null)
	    return false;
	if (date.length() > 10) {
	    sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	} else {
	    sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	try {
	    sdf.parse(date);
	} catch (ParseException pe) {
	    return false;
	}
	return true;
    }

    public static void main(String[] args) throws Exception {
	try {
	    // System.out.print(Integer.valueOf(getTwoDay("2006-11-03 12:22:10", "2006-11-02
	    // 11:22:09")));
	} catch (Exception e) {
	    throw new Exception();
	}
    }

    public static Date getCurrentDate() {
	return getNow();
    }

    // 日期格式化对象,日期型（yyyy-MM-dd）
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 日期格式化对象,日期型（yyyy-MM-dd）
    private static final SimpleDateFormat dateFormats = new SimpleDateFormat("yyyyMMdd");

    // 日期时间格式化对象,日期时间型（yyyy-MM-dd HH:mm:ss）
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式:yyyy-mm-dd<br>
     * 例如:2005-11-02
     */
    public final static String DATE_PATTERN_LINE = "yyyy-MM-dd";

    /**
     * 日期格式:yyyy/mm/dd<br>
     * 例如:2005/11/02
     */
    public final static String DATE_PATTERN_BIAS = "yyyy/MM/dd";

    /**
     * 日期时间格式(24小时制):yyyy-mm-dd HH:mm:ss<br>
     * 例如:2005-11-02 23:01:01
     */
    public final static String DATETIME24_PATTERN_LINE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式:yyyyMMdd<br>
     * 例如:2005/11/02
     */
    public final static String DATE_PATTERN_BIASSS = "yyyyMMdd";

    /**
     * 日期时间格式(12小时制):yyyy-mm-dd hh:mm:ss<br>
     * 例如:2005-11-02 11:01:01
     */
    public final static String DATETIME12_PATTERN_LINE = "yyyy-MM-dd hh:mm:ss";

    /**
     * 日期时间格式(24小时制):yyyy/mm/dd HH:mm:ss<br>
     * 例如:2005/11/02 23:01:01
     */
    public final static String DATETIME24_PATTERN_BIAS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期时间格式(12小时制):yyyy/mm/dd hh:mm:ss<br>
     * 例如:2005/11/02 11:01:01
     */
    public final static String DATETIME12_PATTERN_BIAS = "yyyy/MM/dd hh:mm:ss";

    // 静态初始化时区
    static {
	// 中国时区
	TimeZone tzChina = TimeZone.getTimeZone("Asia/Chongqing");
	DateUtil.dateTimeFormat.setTimeZone(tzChina);
	DateUtil.dateFormat.setTimeZone(tzChina);
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param now 给定日期
     * @return 被格式化后的字符串
     */
    public static String formatDate(java.util.Calendar now) {
	return formatDate(now, DATETIME24_PATTERN_LINE);
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param now            给定日期
     * @param formatePattern 格式化模式
     * @return 被格式化后的字符串<br>
     */
    public static String formatDate(java.util.Calendar now, String formatePattern) {
	if (now == null) {
	    return null;
	}
	if (formatePattern == null || formatePattern.trim().length() <= 0) {
	    formatePattern = DATETIME24_PATTERN_LINE;
	}
	java.util.Date tempDate = now.getTime();
	SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
	return dateFormate.format(tempDate);
    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param date           java.util.Date类型数据
     * @param formatePattern 指定的日期格式化模式
     * @return 格式化后的日期的字符串形式<br>
     * 
     */
    public static String formatDate(java.util.Date date, String formatePattern) {
	if (formatePattern == null || formatePattern.trim().length() <= 0) {
	    formatePattern = DATETIME24_PATTERN_LINE;
	}
	if (date == null) {
	    return "";
	} else {
	    SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
	    return dateFormate.format(date);
	}
    }

    /**
     * 将java.sql.Timestamp数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param date           Timestamp数据
     * @param formatePattern 日期格式化模式
     * @return 格式化后的日期的字符串形式
     */
    public static String formatDate(java.sql.Timestamp date, String formatePattern) {
	if (formatePattern == null || formatePattern.trim().length() <= 0) {
	    formatePattern = DATETIME24_PATTERN_LINE;
	}
	if (date == null) {
	    return "";
	} else {
	    SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
	    return dateFormate.format(date);
	}
    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd
     * 
     * @param date java.util.Date类型数据
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDate(java.util.Date date) {
	return formatDate(date, DATE_PATTERN_LINE);
    }

    /**
     * 将代表日期的长整形数值转换为yyyy-MM-dd HH:mm:ss格式的字符串<br>
     * 
     * @param datetime 需要转换的日期的长整形数值
     * @return 格式化后的日期字符串
     */
    public static String formatDate(long datetime) {
	return formatDate(datetime, DATETIME24_PATTERN_LINE);
    }

    /**
     * 将代表日期的字符串转换yyyy-MM-dd HH:mm:ss格式的字符串
     * 
     * @param datetime 需要转换的日期
     * @return 格式化后的日期字符串
     */
    public static String formate(String datetime) {
	return formatDate(datetime, DATETIME24_PATTERN_LINE);
    }

    /**
     * 将代表日期的字符串转换未指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param datetime       需要转换的日期的字符串
     * @param formatePattern 指定的日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(String datetime, String formatePattern) {
	if (datetime == null || datetime.trim().length() <= 0) {
	    return "";
	}
	try {
	    Date date = null;
	    if (formatePattern != null
		    && (formatePattern.equals(DATE_PATTERN_BIAS) || formatePattern.equals(DATE_PATTERN_LINE))) {
		date = parseDate(datetime);
	    } else {
		date = parseDateTime(datetime);
	    }

	    return formatDate(date, formatePattern);
	} catch (Exception ex) {
	    logger.error("日期转换失败:", ex);
	    throw new RuntimeException("日期转换失败:", ex);
	}
    }

    /**
     * 将代表日期的长整形数值转换为y指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param datetime       需要转换的日期的长整形数值
     * @param formatePattern 指定的日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(long datetime, String formatePattern) {
	if (datetime <= 0) {
	    return "";
	}
	try {
	    Date date = new Date(datetime);
	    return formatDate(date, formatePattern);
	} catch (Exception ex) {
	    logger.error("日期转换失败:", ex);
	    throw new RuntimeException("日期转换失败:", ex);
	}
    }

    /**
     * 将java.sql.Date数据转换为指定格式的字符串<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     * 
     * @param date java.sql.Date类型数据
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDate(java.sql.Date date) {
	return formatDate(toUtilDate(date));
    }

    /**
     * 将java.sql.Date转换为java.util.Date数据类型
     * 
     * @param date 需要转换的java.sql.Date数据
     * @return 转换后的java.util.Date数据
     */
    public static java.util.Date toUtilDate(java.sql.Date date) {
	if (date == null) {
	    return null;
	} else {
	    return new java.util.Date(date.getTime());
	}
    }

    /**
     * 得到当前系统日期
     * 
     * @return 得到系统当前日期
     */
    public static java.sql.Timestamp getCurrentDateTime() {
	return new java.sql.Timestamp(new java.util.Date().getTime());
    }

    /**
     * 将字符串转化为日期型数据<br>
     * 字符串必须是yyyy-MM-dd格式
     * 
     * @param src 日期数据字符串
     * @return java.util.Date型日期类型数据
     */
    public static java.util.Date parseDate(String src) {
	if (src == null || src.trim().length() <= 0) {
	    return null;
	}
	try {
	    return DateUtil.dateFormat.parse(src);
	} catch (ParseException pe) {
	    throw new RuntimeException(pe);
	}
    }

    /**
     * 根据日期、小时、分钟、秒组合成日期时间
     * 
     * @param date   日期
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     * @return 组合后的日期时间
     * @throws PjBaseException
     */
    public static java.util.Date parseDate(String date, int hour, int minute, int second) throws RuntimeException {
	Calendar cal = Calendar.getInstance();

	java.util.Date dateObj = parseDate(date);
	cal.set(getYear(dateObj), getMonth(dateObj), getDay(dateObj), hour, minute, second);
	return cal.getTime();
    }

    /**
     * 将字符串转化为日期型数据<br>
     * 字符串必须是yyyy-MM-dd HH:mm:ss格式
     * 
     * @param src 日期数据字符串
     * @return java.util.Date型日期时间型数据
     */
    public static java.util.Date parseDateTime(String src) {
	if (src == null || src.trim().length()<1) {
	    return null;
	}

	try {
	    return DateUtil.dateTimeFormat.parse(src);
	} catch (ParseException pe) {
	    throw new RuntimeException(pe);
	}
    }

    /**
     * 解析Date，字符串必须是yyyy-MM-dd HH:mm:ss格式
     * 
     * @param src 日期数据字符串
     * @return
     */
    public static Date parseAllDate(String src) {
	try {
	    if (src == null || src.equals(""))
		return null;
	    if (src.length() == 10) {
		return dateFormat.parse(src);
	    } else if (src.length() == 19) {

		return dateTimeFormat.parse(src);
	    } else if (src.length() > 19) {
		src = src.substring(0, 19);
		return dateTimeFormat.parse(src);
	    } else {
		throw new RuntimeException("长度不符。日期格式为:yyyy-mm-dd:,时间格式为:yyyy-mm-dd hh:mi:ss");
	    }

	} catch (ParseException pe) {
	    throw new RuntimeException(pe);
	}
    }

    /**
     * 将java.util.Date转换为java.sql.Date数据类型
     * 
     * @param date 需要转换的java.util.Date数据
     * @return 转换后的java.sql.Date数据
     */
    public static java.sql.Date toSqlDate(java.util.Date date) {
	if (date == null) {
	    return null;
	} else {
	    return new java.sql.Date(date.getTime());
	}
    }

    /**
     * 将java.util.Date转换为java.sql.Timestamp
     * 
     * @param date 需要转换的java.util.Date数据
     * @return 转换后的java.sql.Timestamp
     */
    public static java.sql.Timestamp toTimestamp(java.util.Date date) {
	if (date == null) {
	    return null;
	} else {
	    return new java.sql.Timestamp(date.getTime());
	}
    }

    /**
     * 得到指定年月的最后一天
     * 
     * @param year  指定年
     * @param month 指定月
     * @return 指定年月的最后一天
     */
    public static java.util.Date getMonthLastDay(int year, int month) {
	if (month >= 1 && month <= 12) {
	    Calendar lCal = Calendar.getInstance();
	    lCal.set(year, month, 1);
	    lCal.add(Calendar.DATE, -1);
	    return lCal.getTime();
	} else {
	    throw new RuntimeException("月份传入错误必须介于1和12之间");
	}
    }

    /**
     * 得到指定年月的第一天
     * 
     * @param year  指定年
     * @param month 指定月
     * @return 指定年月的第一天
     */
    public static java.util.Date getMonthFirstDay(int year, int month) {
	if (month >= 1 && month <= 12) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, 1, 0, 0, 0);
	    return cal.getTime();
	} else {
	    throw new RuntimeException("月份传入错误必须介于1和12之间");
	}
    }

    /**
     * 得到指定年月的最后一天的最后小时分秒
     * 
     * @param year  指定年
     * @param month 指定月
     * @return 年月的最后一天的最后小时分秒
     */
    public static java.util.Date getMonthLastDatetime(int year, int month) {
	if (month >= 1 && month <= 12) {
	    Calendar lCal = Calendar.getInstance();
	    lCal.set(year, month, 1, 23, 59, 59);
	    lCal.add(Calendar.DATE, -1);
	    return lCal.getTime();
	} else {
	    throw new RuntimeException("月份传入错误必须介于1和12之间");
	}
    }

    /**
     * 得到指定年月的第一天的开始小时分秒
     * 
     * @param year  指定年
     * @param month 指定月
     * @return 年月的第一天的开始小时分秒
     */
    public static java.util.Date getMonthFirstDatetime(int year, int month) {
	if (month >= 1 && month <= 12) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, 1, 0, 0, 0);
	    return cal.getTime();
	} else {
	    throw new RuntimeException("月份传入错误必须介于1和12之间");
	}
    }

    /**
     * 得到指定日期所在周的指定星期几的日期
     * 
     * @param date      指定日期
     * @param dayOfWeek 指定星期几
     * @return 指定星期几的日期
     */
    public static Date getDateOfWeek(Date date, int dayOfWeek) {
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
	return c.getTime();
    }

    /**
     * 得到指定日期为当前年的第几周
     * 
     * @param date 指定日期
     * @return 当前年的第几周
     */
    public static int getWeekOfYear2(Date date) {
	Calendar cal = Calendar.getInstance();
	cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置周一为一周的第一天
	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置周一为第一天
	cal.setTime(date);
	return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到指定日期为当前年的第几周
     * 
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
	Calendar c = new GregorianCalendar();
	c.setFirstDayOfWeek(Calendar.SUNDAY);
	c.setMinimalDaysInFirstWeek(7);
	c.setTime(date);
	return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到指定年的第几周的第一天日期
     * 
     * @param year  指定年
     * @param nWeek 第几周
     * @return 第一天日期
     */
    public static Date getWeekOfFirstDate(int year, int nWeek) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.WEEK_OF_YEAR, nWeek - 1);
	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);
	return c.getTime();
    }

    /**
     * 周一为一周的第一天
     * 
     * @param year
     * @param nWeek
     * @return
     */
    public static Date getWeekOfFirstDate2(int year, int nWeek) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.WEEK_OF_YEAR, nWeek);
	c.setFirstDayOfWeek(Calendar.MONDAY);
	c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	return c.getTime();
    }

    /**
     * 得到指定年的第几周的最后一天日期
     * 
     * @param year  指定年
     * @param nWeek 第几周
     * @return 最后一天日期
     */
    public static Date getWeekOfLastDate(int year, int nWeek) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.WEEK_OF_YEAR, nWeek);
	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
	return c.getTime();
    }

    /**
     * 星期天为一周的最后一天
     * 
     * @param year
     * @param nWeek
     * @return
     */
    public static Date getWeekOfLastDate2(int year, int nWeek) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.WEEK_OF_YEAR, nWeek);
	c.setFirstDayOfWeek(Calendar.MONDAY);
	c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	return c.getTime();
    }

    /**
     * 获取当前年月日
     * 
     * @return
     */
    public static String getCurrentYmd() {
	Calendar c = Calendar.getInstance();
	int currentMonth = c.get(Calendar.MONTH) + 1;
	return c.get(Calendar.YEAR) + "年" + currentMonth + "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
    }

    /**
     * 根据日期格式转换为年月日格式日期
     * 
     * @param date
     * @return
     */
    public static String getDateYmd(String date) {
	Date parseDateTime = parseDateTime(date);
	Calendar c = Calendar.getInstance();
	c.setTime(parseDateTime);
	int currentMonth = c.get(Calendar.MONTH) + 1;
	return c.get(Calendar.YEAR) + "年" + currentMonth + "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
    }

    public static String getFirstDayOfMonth(int year, int month, String PATTERN_BIASSS) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.MONTH, month);
	c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	return formatDate(c.getTime(), PATTERN_BIASSS);
    }

    public static String getFirstDayOfMonth() {
	return getFirstDayOfMonth(DATE_PATTERN_BIASSS);
    }

    public static String getFirstDayOfMonth(String PATTERN_BIASSS) {
	Calendar c = Calendar.getInstance();
	return getFirstDayOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH), PATTERN_BIASSS);
    }

    public static String getLastDayOfMonth(int year, int month, String PATTERN_BIASSS) {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, year);
	c.set(Calendar.MONTH, month);
	c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	return formatDate(c.getTime(), PATTERN_BIASSS);
    }

    public static String getLastDayOfMonth() {
	return getLastDayOfMonth(DATE_PATTERN_BIASSS);
    }

    public static String getLastDayOfMonth(String PATTERN_BIASSS) {
	Calendar c = Calendar.getInstance();
	return getLastDayOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH), PATTERN_BIASSS);
    }

    public static String getLastDay(String ym) {
	Date d = DateUtil.parseDate(ym);
	Calendar c = Calendar.getInstance();
	c.setTime(d);
	return getLastDayOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH), DATE_PATTERN_LINE);
    }

    /**
     * 得到日期中的年份
     * 
     * @param date 日期
     * @return 年份
     */
    public static int getYear(java.util.Date date) {
	if (date == null) {
	    return 0;
	}
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c.get(Calendar.YEAR);
    }

    /**
     * 得到日期中的月份
     * 
     * @param date 日期
     * @return 月份
     */
    public static int getMonth(java.util.Date date) {
	if (date == null) {
	    return 0;
	}
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c.get(Calendar.MONTH);
    }

    /**
     * 得到日期中的天
     * 
     * @param date 日期
     * @return 天
     */
    public static int getDay(java.util.Date date) {
	if (date == null) {
	    return 0;
	}
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到日期中的小时
     * 
     * @param date 日期
     * @return 小时
     */
    public static int getHour(java.util.Date date) {
	if (date == null) {
	    return 0;
	}
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 得到当前月<br>
     * 0:一月;1:二月;....;11:十二月
     * 
     * @return 当前月
     */
    public static int getCurrentMonth() {
	Calendar c = Calendar.getInstance();
	return c.get(Calendar.MONTH);
    }

    /**
     * 根据指定日期得到上一个月的年月（yyyy-MM）
     * 
     * @param ym （yyyy-MM-dd）
     * @return
     */
    public static String getPreYm(String ym) {
	Date d = DateUtil.parseDate(ym);
	d.setMonth(d.getMonth() - 1);
	return formatDate(d, "yyyy-MM");
    }

    /**
     * 根据日期判断是星期几1:表示星期一
     * 
     * @param pTime
     * @return
     * @throws Throwable
     */
    @SuppressWarnings("deprecation")
    public static int dayForWeek(String pTime) throws Throwable {

	try {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    Date tmpDate = format.parse(pTime);

	    Calendar cal = new GregorianCalendar();

	    cal.set(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());

	    return cal.get(Calendar.DAY_OF_WEEK);
	} catch (Exception e) {
	    throw new Throwable();
	}
    }

    /**
     * 取某个时间点后几个月的某个时间点
     * 
     * @param d     原日期
     * @param count 几个月后
     * @return 目标日期
     */
    public static Date afterMonths(Date d, int count) {
	Calendar c = Calendar.getInstance();
	c.setTime(d);
	c.set(Calendar.MONTH, c.get(Calendar.MONTH) + count);
	return c.getTime();
    }

    /**
     * 得到指定年的第一天
     * 
     * @param year 指定年
     * @return 指定年的第一天
     */
    public static java.util.Date getYearFirstDay(int year) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, 0, 1, 0, 0, 0);
	return cal.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	smdate = sdf.parse(sdf.format(smdate));
	bdate = sdf.parse(sdf.format(bdate));
	Calendar cal = Calendar.getInstance();
	cal.setTime(smdate);
	long time1 = cal.getTimeInMillis();
	cal.setTime(bdate);
	long time2 = cal.getTimeInMillis();
	long between_days = (time2 - time1) / (1000 * 3600 * 24);

	return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.setTime(sdf.parse(smdate));
	long time1 = cal.getTimeInMillis();
	cal.setTime(sdf.parse(bdate));
	long time2 = cal.getTimeInMillis();
	long between_days = (time2 - time1) / (1000 * 3600 * 24);

	return Integer.parseInt(String.valueOf(between_days));
    }

    public static String turnDate(String showDate, String format, int interDay) {

	// 日期加指定天数
	Calendar cal = Calendar.getInstance();

	Date tempDate_001 = DateUtil.parseDates(showDate);
	if (null == tempDate_001) {
	    return null;
	}
	cal.setTime(tempDate_001);

	cal.add(Calendar.DAY_OF_MONTH, interDay);

	String next = DateUtil.formatDates(cal.getTime(), format);

	return next;

    }

    /**
     * 日期增加天数
     * 
     * @param date
     * @param interDay
     * @return
     */
    public static Date addDate(Date date, int interDay) {

	// 日期加指定天数
	Calendar cal = Calendar.getInstance();

	if (null == date) {
	    return null;
	}
	cal.setTime(date);

	cal.add(Calendar.DAY_OF_MONTH, interDay);

	return cal.getTime();

    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyyMMdd HH:mm:ss
     * 
     * @param date           java.util.Date类型数据
     * @param formatePattern 指定的日期格式化模式
     * @return 格式化后的日期的字符串形式<br>
     * 
     */
    public static String formatDates(java.util.Date date, String formatePattern) {
	if (formatePattern == null || formatePattern.trim().length() <= 0) {
	    formatePattern = DATE_PATTERN_BIASSS;
	}
	if (date == null) {
	    return "";
	} else {
	    SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
	    return dateFormate.format(date);
	}
    }

    /**
     * 将字符串转化为日期型数据<br>
     * 字符串必须是yyyyMMdd格式
     * 
     * @param src 日期数据字符串
     * @return java.util.Date型日期类型数据
     */
    public static java.util.Date parseDates(String src) {
	if (src == null || src.trim().length() <= 0) {
	    return null;
	}
	try {
	    return DateUtil.dateFormats.parse(src);
	} catch (ParseException pe) {
	    throw new RuntimeException(pe);
	}
    }

    public static int getYearOfCurrentDate() {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
	return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(String dateStr) {
	return getMonth(parseDate(dateStr));
    }

    /**
     * 将字符串的时间格式转换为数字类型 如："9:00" -> 9.0
     * 
     * @param sTime
     * @return
     */
    public static double timeStringToDouble(String sTime) {
	List<String> list = new ArrayList<String>();
	double total = 0;
	String[] time = sTime.split(":");
	for (int i = 0; i < time.length; i++) {
	    String str = time[i];
	    list.add(str);
	}
	for (int j = 0; j < 1; j++) {
	    String left = list.get(0);
	    String right = list.get(1);

	    // 转换成数字类型 int double
	    int leftInt = Integer.parseInt(left);
	    double rightDou = Double.parseDouble(right);
	    double rightDou2 = rightDou / 60;
	    total = leftInt + rightDou2;
	}
	return total;
    }
    
    
    /**
     * 得到几天前的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d,int day){
     Calendar now =Calendar.getInstance();
     now.setTime(d);
     now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
     return now.getTime();
    }
    
    /**
     * 得到几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d,int day){
     Calendar now =Calendar.getInstance();
     now.setTime(d);
     now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
     return now.getTime();
    }
    
    /***
     * 
     * 上月第一天
     * 
     */
    public static String getPreviousMonthFirst(String date) {
	Calendar calendar = Calendar.getInstance();// 实例化日历
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	try {
	    calendar.setTime(sdf.parse(date));
	    calendar.set(Calendar.DATE, 1);// 设为当前月的1号
	    calendar.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
	} catch (ParseException e) {

	    e.printStackTrace();
	}

	return sdf.format(calendar.getTime());
    }

    /***
     * 
     * 上月最后一天
     * 
     */
    public static String getPreviousMonthEnd(String date) {
	Calendar calendar = Calendar.getInstance();// 实例化日历
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	try {
	    calendar.setTime(sdf.parse(date));
	    calendar.add(Calendar.MONTH, -1);// 减一个月
	    calendar.set(Calendar.DATE, 1);// 把日期设置为当月第一天
	    calendar.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	return sdf.format(calendar.getTime());
    }
}
