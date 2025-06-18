package com.wldst.ruder.domain;

import java.util.Map;

import com.wldst.ruder.util.MapTool;

/**
 * 状态相关
 * @author wldst
 *
 */
public class StatusDomain extends MapTool{
	protected static final String  STATUS="status";
	protected static final String  STATE_MACHINE ="stateMachine";
	protected static final String  STATE_STEP ="stateStep";
	
	protected static final String  STATUS_ON="1";
	protected static final String  STATUS_OFF="0";
	
	protected static final String  STATUS_OPEN="0";	
	protected static final String  STATUS_CLOSE="0";
	 
	public static String status(Map<String, Object> mapData) {
		    return string(mapData, STATUS);
	}
 
}
