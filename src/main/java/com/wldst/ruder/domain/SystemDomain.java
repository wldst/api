package com.wldst.ruder.domain;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 系统设置相关的常量
 * 
 * @author wldst
 *
 */
public class SystemDomain extends StatusDomain {
 
    
    protected static final String SETTING = "Settings";
    protected static final String MY_SETTING = "MySetting";
    protected static final String BACKGROUND_IMG = "BackGroundImg";
    
    
    protected static final String VALUE = "value";
    protected static final String PLUGIN_PATH = "plugin.path";
    protected static final String INIT_DATA = "file.data";
    protected static final String PROT_DATA = "port.data";
    protected static final String SYSTEM_LABEL = "system";
    protected static final String STATE = "STATE";
    protected static final String VERSION = "version";
    protected static final String VERSION_LOG = "versionLog";
    public static final String LOGIN_LOG ="LoginLog";
    public static final String OPERATE_LOG ="operateLog";
    
    public static final String LABEL_NOTICE ="Notice";
    
    public static final String CMD_NOTICE ="notice";
    public static final String CMD ="cmd";
    public static final String CMD_REPORT ="report";
    public static final String CMD_PUSH ="push";
    
    public final static String HOST = "host";
    public final static String URI = "uri";
    public final static String PORT = "port";
    
    public static final String FILE_STORE_PATH = "file_store_path";
    public static final String UI_PUBLISH_PATH = "ui_publish_path";
    
    
//    @SuppressWarnings("preview")
//    public static ExecutorService getExecutorService() {
//	 return  Executors.newVirtualThreadExecutor();
////	 return Executors.newVirtualThreadPerTaskExecutor();
//    }
    
    
    public static String host(Map<String, Object> mapData) {
	    return string(mapData, HOST);
    }
    public static String uri(Map<String, Object> mapData) {
	    return string(mapData, URI);
    }
    public static Integer port(Map<String, Object> mapData) {
	    return integer(mapData, PORT);
    }
    public static String portStr(Map<String, Object> mapData) {
	    return string(mapData, PORT);
    }
    

}
