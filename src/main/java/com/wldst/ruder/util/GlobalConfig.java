package com.wldst.ruder.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class GlobalConfig {
    private static final String GLOBAL_PROPERTIES = "/application.properties";

    private static Map<String, String> properties;

    public static Map<String, String> getProperties() {
        return properties;
    }

    public static void setProperties(Map<String, String> properties) {
        GlobalConfig.properties = properties;
    }

    /**
     * 通过路径读取配置文件
     * 
     * @param path
     * @return
     */
    public static Properties loadProperties(String path) {
	Properties properties = new Properties();
	try {
	    InputStream is = GlobalConfig.class.getResourceAsStream(path);
	    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	    properties.load(isr);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return properties;
    }

    /**
     * 获取globalConfig.properties、main.properties数据
     * 
     * @param key
     * @return
     */
    public static String getProperty(String key) {
	if (properties == null) {
	    properties = new HashMap<String, String>();
	    // 获取globalConfig.properties数据
	    Properties temp = loadProperties(GLOBAL_PROPERTIES);
	    for (Object keyt : temp.keySet()) {
		if (keyt != null) {
		    properties.put(keyt.toString(), temp.getProperty(keyt.toString()));
		}
	    }
	}
	return properties.get(key);
    }

    /**
     * 判断是否具有领导日程表管理权限
     * 
     * @param userId
     * @return
     */
    public static boolean isCalendarManager(String userId) {
	String manager = getProperty("canlendar_manager").toLowerCase();
	if (manager != null && userId != null && manager.contains(userId.toLowerCase())) {
	    return true;
	}
	return false;
    }

    /**
     * 获得日程展示天数
     * 
     * @return
     */
    public static int getCalendarDay() {
	String day = getProperty("canlendar_day");
	if (day == null) {
	    return 7;
	} else {
	    return Integer.parseInt(day);
	}
    }

}
