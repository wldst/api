package com.wldst.ruder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.wldst.ruder.api.RuderApi;

public class DomainRepo extends com.wldst.ruder.util.MapTool {

     
    public static void delete(Map<String, Object> map) {
	Map<String, Object> copy = copy(map);
	copy.remove(LABEL);
	String postRequest2 = RuderApi.postRequest2("/cd/cruder/"+label(map)+"/del", map);
//	JSONObject parseArray = JSON.parseObject(postRequest2);
    }
 
    
    public static void deleteById(String id) {
	RuderApi.delete(Long.valueOf(id));
    }
   

    public  static List<String> colDataList(JSONObject parseArray, String xxID) {
	return listMap2ListString(xxID, listMapObject(parseArray, "data"));
    }

      

    public static  Map<String, Object> getOne(Map<String, Object> map, String label) {
	return RuderApi.queryOne(map, "/cd/cruder/" + label + "/getOne");
    }

    public  static Map<String, Object> getOneById(Long id, String label) {
	if (id == null) {
	    return newMap();
	}
	return RuderApi.getOne("/cd/cruder/" + label + "/get/" + id);
    }

    public  static Map<String, Object> getDetailById(Long id, String label) {
	if (id == null) {
	    return newMap();
	}
	return RuderApi.getOne("/cd/cruder/" + label + "/detail/" + id);
    }

     
     

    public  static StringBuilder cyhperCondition(Map<String, Object> paramMap, String[] columns2) {
	StringBuilder conditions = new StringBuilder();
	Set<String> keySet = paramMap.keySet();
	for (String ki : keySet) {
	    if (conditions.length() > 1) {
		conditions.append(" and ");
	    }
	    for (String ci : columns2) {

		if (ci.equals(ki)) {
		    conditions.append(ci + "='" + string(paramMap, ki) + "'");
		} else if (ci.contains(ki) && ci.split("AS")[1].trim().equals(ki)) {
		    conditions.append(ci.split("AS")[0].trim() + "='" + string(paramMap, ki) + "'");
		}
	    }
	}
	return conditions;
    }

    public  static String cypherWithCondition(String cypher2, String conditions) {
	String voDataCypher = null;
	List<String> wr = new ArrayList<>();
	wr.add(" WHERE , RETURN ");
	wr.add(" where , RETURN ");
	wr.add(" WHERE , return ");
	wr.add(" where , return ");
	
	for(String wi: wr) {
	    String[] wrs = wi.split(",");
	    if(cypher2.contains(wrs[1])) {
		    String where = wrs[0];
			String returnStr = wrs[1];
			if (!cypher2.contains(where)) {
			    String[] split = cypher2.split(returnStr);
			    voDataCypher = split[0] + where + conditions + returnStr + split[1];
			} else {
			    String[] split = cypher2.split(where);
			    voDataCypher = split[0] + where + conditions + split[1];
			}
			if(voDataCypher!=null) {
			    return voDataCypher;
			}
		}
	}
	
	return voDataCypher;
    }

      
    public  static Long saveFile(Map<String, Object> map) {
	return RuderApi.save(map, "File");
    }

    public  static Long save(Map<String, Object> map, String label) {
	return RuderApi.save(map, label);
    }

    public  static Long updateBy(Map<String, Object> map, String label,String key,String value) {
	Map<String, Object> mapp = newMap();
	mapp.put(key, value);
	Map<String, Object> one = getOne(mapp, label);
	map.put(ID, id(one));
	return RuderApi.save(map, label);
    }

    public  static Map<String, Object> query(Map<String, Object> map, String label) {
	return RuderApi.query(map,"/cd/cruder/" + label + "/query");
    }
    
    public  static List<Map<String, Object>> dataList(Map<String, Object> map, String label){
	return dataList(query(map,label));
    }
    
    public  static List<Map<String, Object>> listAll(String label) {
	return RuderApi.listAllByLabel(label);
    }



    public  static Map<String, Object> pages(Map<String, Object> map, String label, int pageSize, int pageNum) {
	map.put("pageSize", pageSize);
	map.put("pageNum", pageNum);
	return RuderApi.query(map,"/cd/cruder/" + label + "/query");
    }
}
