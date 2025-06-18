package com.wldst.ruder.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedObjectMapper {
    public static Map<String, Object> deepConvert(Object obj) {
        Map<String, Object> result = new HashMap<>();
        Class<?> clazz = obj.getClass();
        
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
		try {
		    value = field.get(obj);
		    result.put(field.getName(), convertValue(value));
		} catch (IllegalArgumentException | IllegalAccessException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
                
            }
            clazz = clazz.getSuperclass();
        }
        return result;
    }

    private static Object convertValue(Object value) {
        if (value == null) return null;
        if (value instanceof Collection) {
            return ((Collection<?>) value).stream()
                    .map(AdvancedObjectMapper::convertValue)
                    .collect(Collectors.toList());
        }
        if (value instanceof Map) {
            return ((Map<?, ?>) value).entrySet().stream()
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> convertValue(entry.getValue())
                    ));
        }
        // 添加其他类型处理逻辑...
        return value;
    }
}
