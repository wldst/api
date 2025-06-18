package com.wldst.ruder.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wldst.ruder.util.GlobalConfig;

public class WorkFlowApi extends RuderApi {
    private static Logger log = LoggerFactory.getLogger(WorkFlowApi.class);
    
    private static final String ruderContext = GlobalConfig.getProperty("ruder_name").trim();

    public static Map<String, Object> agree(String key, String value, String label) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("key", key);
  	newMap.put("executorIDs", value);
  	newMap.put("loginName", label);
  	Object postRequest = postRequest(ruderContext+"/bpm/agree/agree", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
      }
    public static Map<String, Object> initAgree(String key, String value, String label) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("key", key);
  	newMap.put("executorIDs", value);
  	newMap.put("loginName", label);
  	Object postRequest = postRequest(ruderContext+"/bpm/agree/init/{flowId}", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> commitInit(String bizId, String value, String label) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("bizId", bizId);
  	newMap.put("executorIDs", value);
  	newMap.put("loginName", label);
  	Object postRequest = postRequest(ruderContext+"/bpm/commit/init/"+bizId, newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> commit(String flowId, String value, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", value);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/commit/init/{flowId}", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    
    
    public static Map<String, Object> disAgreeInit(String flowId, String executorIDs, String label) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("bizId", flowId);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", label);
  	Object postRequest = postRequest(ruderContext+"/bpm/disAgree/init/"+flowId, newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> disAgree(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/disAgree", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> preExcutors(String flowId, String taskId, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("taskId", taskId);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/disAgree/preExcutors", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> callback(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/callback", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    
    public static Map<String, Object> completedTask2(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/turnback/completedTask2/"+flowId, newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> turnback(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/turnback/turnback", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    public static Map<String, Object> reverse(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpm/turnback/reverse", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    
    public static Map<String, Object> todoList(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpmApi/todoList", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    
    public static Map<String, Object> doneList(String flowId, String executorIDs, String loginName,String executeComment) {
  	Map<String, Object> newMap = newMap();
  	newMap.put("flowId", flowId);
  	newMap.put("executeComment", executeComment);
  	newMap.put("executorIDs", executorIDs);
  	newMap.put("loginName", loginName);
  	Object postRequest = postRequest(ruderContext+"/bpmApi/doneList", newMap);
  	Map<String, Object> data = (Map<String, Object>) postRequest;
  	return data;
    }
    
    

}
