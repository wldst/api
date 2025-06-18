package com.wldst.ruder.domain;

import java.util.HashMap;
import java.util.Map;

public class DomainBuffer {
	private static Map<String,String> bufferCode = new HashMap<>();

	public static Map<String,String> getBufferCode() {
		return bufferCode;
	}

	public static void setBufferCode(Map<String,String> bufferCode) {
		DomainBuffer.bufferCode = bufferCode;
	}
	
	public static void clear() {
	    bufferCode.clear();
	}
	

}
