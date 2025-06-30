package com.wldst.ruder.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.wldst.ruder.domain.BeanShellDomain;
import com.wldst.ruder.domain.DomainBuffer;
import com.wldst.ruder.domain.SystemDomain;
import com.wldst.ruder.util.GlobalConfig;
import com.wldst.ruder.util.HttpRequest2;

public class RuderApi extends SystemDomain {
    private static Logger log = LoggerFactory.getLogger(RuderApi.class);
    private static final String xx = "http://192.168.0.11:9100";
    private static final String xx2 = "https://192.168.102.72:9443";
    
    private static final String ruderContext = GlobalConfig.getProperty("ruder_name").trim();

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Map<String, Object> jo = new HashMap<String, Object>();
	postRequest(ruderContext+"/cruder/dataSet/save", jo);
    }

    public static Map<String, Object> saveObject(String label, Map<String, Object> map) {
	return postRequest(ruderContext+"/cruder/" + label + "/save", map);
    }
    
    public static Long save( String label,Map<String, Object> map) {
	return save(map,label);
    }
    
    public static boolean isExists(String label,String key,String value){
	Map<String, Object> attMapBy = getAttMapBy(key, value, label);
	return attMapBy==null||attMapBy.isEmpty();
    }

    public static Long save(Map<String, Object> map, String label) {
	String postRequest2 = postRequest2(ruderContext+"/cruder/" + label + "/save", map);
	if (postRequest2 != null) {
	    JSONObject parseArray = JSONObject.parseObject(postRequest2);
	    if(parseArray==null) {
		return null;
	    }
	    Map<String, Object> data2 = data(parseArray);
	    if(data2==null) {
		return null;
	    }
	    Long id = longValue(data2, "value");
	    map.put(ID, id);
	    return id;
	}
	return null;
    }
    /**
     *        	String rel = vo.getString("rel");
	 // 获取关系属性
	    Map<String, Object> relProps = mapObject(vo, "relProp");

	    Long endId = longValue(vo, "endId") ;
	    Long startId = longValue(vo, "startId");
     * @param map
     * @param label
     * @return
     */
    public static void addRel(Map<String, Object> map) {
	String postRequest2 = postRequest2(ruderContext+"/manage/relation", map);
    }
    
    public static Map<String, Object> query(Map<String, Object> map, String api) {
	String postRequest2 = RuderApi.postRequest2(api, map);
	JSONObject parseArray = JSONObject.parseObject(postRequest2);
	if (parseArray == null) {
	    return null;
	}
	return parseArray;
    }
    
    public static List<Map<String, Object>> dataList(Map<String, Object> map, String api) {
   	Map<String, Object> queryData = query(map,api);
   	if(queryData==null||queryData.isEmpty()) {
   	    return null;
   	}
	return dataList(queryData);
    }
    
    public static List<Map<String, Object>> getList(String label,String key,String value){
	Map<String, Object> map = newMap();
	map.put(key,value);
	return queryList(map,label);
    }
    public static List<Map<String, Object>> queryList(Map<String, Object> map, String label) {
   	return dataList(query(map,ruderContext+"/cruder/"+label+"/query"));
    }
    public static List<Map<String, Object>> search(Map<String, Object> map, String label) {
   	return dataList(query(map,ruderContext+"/cruder/"+label+"/search"));
    }
    
    public static Map<String, Object> queryOne(String cypher) {
	Map<String, Object> param = newMap();
	param.put(CYPHER, cypher);
	Map<String, Object> query = query(param, ruderContext+"/cypher/data");
	List<Map<String, Object>> dataList = dataList(query);
	if(query==null||query.isEmpty()||dataList==null||dataList.isEmpty()) {
	    return null;
	}
	Map<String, Object> one = dataList.get(0);
	return one;
    }
    
    public static List<Map<String, Object>> query(String cypher) {
	Map<String, Object> param = newMap();
	param.put(CYPHER, cypher);
	Map<String, Object> query = query(param, ruderContext+"/cypher/data");
	List<Map<String, Object>> dataList = dataList(query);
	 
	return dataList;
    }

    public static Map<String, Object> queryOne(Map<String, Object> map, String api) {
	String postRequest2 = RuderApi.postRequest2(api, map);
	JSONObject parseArray = JSONObject.parseObject(postRequest2);
	if (parseArray == null) {
	    return null;
	}
	return mapObject(parseArray, "data");
    }
    
    public static Object runBeanShell(String beanShell) {
	Map<String, Object> map=newMap();
	map.put(BeanShellDomain.BS_SCRIPT,beanShell);
	save(map, "BeanShell");
	
	String postRequest2 = RuderApi.postRequest2(ruderContext+"/bs/run/BeanShell/"+stringId(map), map);
	JSONObject parseArray = JSONObject.parseObject(postRequest2);
	if (parseArray == null) {
	    return null;
	}
	return string(parseArray, "data");
    }
    
    public static Map<String, Object> talk(Map<String, Object> map) {
	return postRequest(ruderContext+"/auth/talk", map);
    }
    
    
    
    
    public static String getOneValue(String api) {
	String postRequest2 = RuderApi.postRequest2(api, newMap());
	try {
	    JSONObject parseArray = JSONObject.parseObject(postRequest2);
		if (parseArray == null) {
		    return null;
		}
		String data = string(parseArray, "data");
		if(data==null) {
		    return null;
		}
		return data.trim();
	}catch (Exception e) {
	    log.error("getOneValue："+api,e);
	    return null;
	}
	
    }
    
    public static String getOneValue(String api,Map<String,Object> param) {
	String postRequest2 = RuderApi.postRequest2(api, param);
	JSONObject parseArray = JSONObject.parseObject(postRequest2);
	if (parseArray == null) {
	    return null;
	}
	return string(parseArray, "data");
    }

    public static void saveObjects(String label, List<Map<String, Object>> maps) {
	Map<String, Object> map = new HashMap<>();
	map.put("data", maps);
	postRequest(ruderContext+"/api/" + label + "/import", map);
    }

    public static void savePmisUser(List<Map<String, Object>> maps) {
	if (maps != null && !maps.isEmpty()) {
	    saveObjects("PmisUser", maps);
	}

    }

    public static void savePmisProject(List<Map<String, Object>> maps) {
	if (maps != null && !maps.isEmpty()) {
	    saveObjects("PmisProject", maps);
	}
    }

    public static void savePmisGxr(List<Map<String, Object>> maps) {
	if (maps != null && !maps.isEmpty()) {
	    saveObjects("PmisGxRen", maps);
	}
    }

    public static Map<String, Object> postRequest(String url, Map<String, Object> map) {
	String string = jsonString(map);
	String postUrl =  getPostUrl(url);
	log.info(postUrl+"==========================:" + url);
	log.info("params:" + string);
	String sendPostJSON = HttpRequest2.sendPostJSON(postUrl, string, false);
	try {
	    log.info(sendPostJSON);
	    Map<String,Object> json = JSONObject.parseObject(sendPostJSON,Map.class);
	    return (Map<String, Object>) json.get("data");
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error(e.getMessage(),e);
	}

	return null;
    }

    public static String postRequest2(String url, Map<String, Object> jo) {
	String sendPostJSON = HttpRequest2.sendPostJSON(getPostUrl(url), jsonString(jo), false);
	return sendPostJSON;
    }

    public static String getPostUrl(String url) {
	String postUrl = GlobalConfig.getProperty("ruder_url");
	if(url.startsWith("/cd/")) {
	    url= url.replace("/cd/",ruderContext+"/");
	}
	if (postUrl == null) {
	    postUrl = xx + url;
	} else {
	    if(postUrl.endsWith("/")&&url.startsWith("/")) {
		postUrl = postUrl + url.substring(1);
		}else {
		    postUrl = postUrl + url;
		}
	}
	
	return postUrl;
    }
    public static String module() {
	    String property = GlobalConfig.getProperty("ruder_name");
	    if (property == null)
	      return "/cd/"; 
	    return "/" + property.trim() + "/";
	  }

    public static String get(String url) {
	String sendPostJSON = HttpRequest2.sendGet(getPostUrl(url), null);
	return sendPostJSON;
    }

    public static Map<String, Object> getOne(String url) {
	String getData = get(url);
	if (getData != null&&!"".equals(getData)) {
	    Map<String,Object> parseArray = JSONObject.parseObject(getData, Map.class);
	    return parseArray;
	}
	return null;
    }
    
    public static Map<String, Object> getConfig(String code) {	
	String getData = get(ruderContext+"/manage/" + code + "/configItem");
	if (getData != null&&!"".equals(getData)) {
	    Map<String,Object> parseArray = JSONObject.parseObject(getData, Map.class);
	    return parseArray;
	}
	return null;
    }
    /**
     * 根据ID和Label获取
     * @param id
     * @param label
     * @return
     */
    public static Map<String, Object> getOne(String id,String label) {
	String getData = get(ruderContext+"/cruder/"+label+"/get/"+id);
	if (getData != null&&!getData.equals("")) {
	    return JSONObject.parseObject(getData, Map.class);
	}
	return null;
    }
    public static void deleteBy(Map<String, Object> param,String label) {
	List<Map<String, Object>> queryList = queryList(param, label);
	    if (!queryList.isEmpty()) {
		for (Map<String, Object> qi : queryList) {
		    RuderApi.delete(id(qi));
		}
	    }
    }
    
    
    public static Map<String, Object> getOne(Long id) {
	String getData = get(ruderContext+"/node/get/"+String.valueOf(id));
	if (getData != null&&!getData.equals("")) {
	   return JSONObject.parseObject(getData, Map.class);
	}
	return null;
    }

    public static String serverSetting(String key) {
	return getOneValue(ruderContext+"/manage/setting/" + key);
    }
    
    public static Boolean isOn(String key) {
	  String oneValue = getOneValue(ruderContext+"/manage/setting/" + key);
	  if("on".equalsIgnoreCase(oneValue)||"true".equalsIgnoreCase(oneValue)||"1".equals(oneValue)) {
	      return true;
	  }
	  if("off".equalsIgnoreCase(oneValue)||"false".equalsIgnoreCase(oneValue)||"0".equals(oneValue)) {
	      return false;
	  }
	  return false;
    }
    
    public static String filePath(String key) {
	     return validPath(getOneValue(ruderContext+"/manage/setting/" + key));
    }

    public static String serverFilePath() {
	return getOneValue(ruderContext+"/manage/path");
    }

    public String getBySysCode(String key) {

	return getSettingBy(key);
    }

    public String getPathBy(String key) {
	String path = getBySysCode(key);

	String runPath = System.getProperty("user.dir") + File.separator;
	if (runPath.contains("workspace")) {
	    runPath = runPath + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
	}

	if (path == null) {

	    if (FILE_STORE_PATH.equals(key)) {
		path = runPath + "fileStore";
	    }
	    if ("staticFile".equals(key)) {
		path = runPath + "static";
	    }
	    if (UI_PUBLISH_PATH.equals(key)) {
		path = runPath + "page";
	    }
	} else {
	    if (path.contains("../")) {
		path = path.replaceAll("../", "");
	    }
	    path = runPath + path;
	}
	path=validPath(path);
	return path;
    }

    public static String validPath(String path) {
	if(path==null) {
	    return "/";
	}
	if(path.startsWith("http://")) {
	    if (!path.endsWith("/")) {
		return path+"/";
	    }
	    return path;
	}
	if (!path.endsWith(File.separator)) {
	    return path + File.separator;
	}
	return path;
    }

    private String getSettingBy(String key) {
	Map<String, String> bufferCode = DomainBuffer.getBufferCode();
	if (bufferCode.containsKey(key)) {
	    return bufferCode.get(key);
	} else {
	    Map<String, Object> attMapBy = getAttMapBy(CODE, key, SETTING);
	    if (attMapBy == null || !attMapBy.containsKey(VALUE)) {
		return null;
	    }
	    String valueOfCode = String.valueOf(attMapBy.get(VALUE));
	    bufferCode.put(key, valueOfCode);
	    return valueOfCode;
	}
    }

    public static Map<String, Object> getAttMapBy(String key, String value, String label) {
	Map<String, Object> newMap = newMap();
	newMap.put("key", key);
	newMap.put("value", value);
	newMap.put("label", label);
	Object postRequest = postRequest(ruderContext+"/metadata/getAttMapBy", newMap);
	Map<String, Object> data = (Map<String, Object>) postRequest;
	return data;
    }
    public static Map<String, Object> getBy(String key, Object value, String label) {
	Map<String, Object> newMap = newMap();
	newMap.put("key", key);
	newMap.put("value", value);
	newMap.put("label", label);
	Object postRequest = postRequest(ruderContext+"/metadata/getAttMapBy", newMap);
	Map<String, Object> data = (Map<String, Object>) postRequest;
	return data;
    }

    public static List<Map<String, Object>> listAllByLabel(String label) {
	return dataList(query(newMap(), ruderContext+"/cruder/"+label+"/listAll"));
    }
    
    public static List<Map<String, Object>> listAllStatus(String label) {
	return dataList(query(newMap(), ruderContext+"/status/list/"+label));
    }
    
    public static List<Map<String, Object>> setStatus(String nodeId,String status) {
	return dataList(postRequest( ruderContext+"/status/set/"+nodeId+"/"+status,newMap()));
    }
    
    public static List<Map<String, Object>> settingStatus(String label,List<Map<String, Object>> status) {
	Map<String, Object> newMap = newMap();
	newMap.put("status",status);
	return dataList(postRequest( ruderContext+"/status/setting/"+label,newMap));
    }
    public static List<Map<String, Object>> clearSet(String label,List<Map<String, Object>> status) {
	Map<String, Object> newMap = newMap();
	newMap.put("status",status);
	return dataList(postRequest( ruderContext+"/status/clearSet/"+label,newMap));
    }
    
    public static List<Map<String, Object>> addStatus(String label,Map<String, Object> status) {
	return dataList(postRequest( ruderContext+"/status/add/"+label,status));
    }
    
    public static Map<String, Object> customField(String label,String field,Object value) {	
	Map<String,Object> vo = new HashMap<>();	 
	vo.put("poId", label);
	vo.put("filed",field);	
	// 查询自定义字段数据
	List<Map<String, Object>> fieldInfoList = queryList(vo, "Field");
	if(fieldInfoList==null) {
	    return null;
	}
	for(Map<String, Object> fi: fieldInfoList) {
	    String type2 = type(fi);
	    if(type2!=null) {		
		String valueField = string(fi,"valueField");
		if(valueField!=null) {
		    Map<String, Object> attMapBy = RuderApi.getAttMapBy(field, valueField, type2);
		    if(attMapBy!=null) {
			return attMapBy;
		    }
		}else {
		    Map<String,Object> param = new HashMap<>();
		    param.put(SEARCH_VAL, value);
		    List<Map<String, Object>> search = RuderApi.search(param, type2);
		    if(search!=null) {
			for(Map<String, Object> si: search) {
			    for(Entry<String,Object> ei:si.entrySet()) {
				if(ei.getValue().equals(value)) {
				    return si;
				}
			    }
			}
		    }
		}		
	    } 
	}
	 
	return null;
    }
    
    public static Map<String, Object> statusInfo(String label,String field,Object value) {
	Map<String, Object> newMap = newMap();
	newMap.put("value",value);
	return data(postRequest( ruderContext+"/status/info/"+label,newMap));
    }
    
    
    
    public static List<Map<String, Object>> status(String nodeId) {
	return dataList(postRequest( ruderContext+"/status/"+nodeId,newMap()));
    }
    
    public static List<Map<String, Object>> listTheCol(String label,String  cols) {
	// TODO Auto-generated method stub
	Map<String, Object> newMap = newMap();
	newMap.put("columns", cols);
	return dataList(query(newMap, ruderContext+"/cruder/"+label+"/listSomeCol"));
    }
    
    
    public static List<Map<String, Object>> listTheCol(String label,String  cols,Map<String,Object> vo) {
	vo.put("columns", cols);
	return dataList(query(vo, ruderContext+"/cruder/"+label+"/listSomeCol"));
    }
    
    
    /**
     * 获取指定字段的映射关系
     * @param label
     * @param key
     * @param value
     * @return
     */
    public static Map<String, String> mapAllBy(String label,String key,String value) {
	Map<String, String> xx = new HashMap<>();
	List<Map<String, Object>> listAllByLabel = listAllByLabel(label);
	for(Map<String, Object> mi: listAllByLabel) {
	    xx.put(string(mi,key),string(mi,value));
	}
	return  xx;
    }

    
    public static void delete(Long sessionId) {
	Map<String, Object> newMap = newMap();
	newMap.put(ID, sessionId);
	query(newMap, ruderContext+"/manage/delBy");
    }
    
    public static void delete(Map<String, Object> newMap) {
	List<Map<String, Object>> query = dataList(query(newMap, ruderContext+"/manage/query"));
	if(query!=null&&!query.isEmpty()) {
		for(Map<String, Object> qi:query) {
		    delete(id(qi));
		}
	}
    }

}
