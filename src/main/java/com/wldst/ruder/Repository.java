package com.wldst.ruder;

import java.util.List;
import java.util.Map;
/**
 * 通用库，增删改查
 * @author wldst
 *
 */
public interface Repository {

    Map<String, Object> getOneById(Long id, String label);

    Map<String, Object> getOne(Map<String, Object> map, String label);

    Map<String, Object> getDetailById(Long id, String label);

    Long saveFile(Map<String, Object> map);

    Long save(Map<String, Object> map, String label);

    Map<String, Object> query(Map<String, Object> map, String label);

    Map<String, Object> pages(Map<String, Object> map, String label, int pageSize, int pageNum);

    List<Map<String, Object>> listAll(String label);

    void delete(Map<String, Object> map);
}
