package com.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ParameterUtil {

	public static Map<String,String> convertMap(HttpServletRequest request){
		Map<String,String[]> paramMap = request.getParameterMap();
		Iterator<String> it = paramMap.keySet().iterator();
		Map<String,String> map = new HashMap<>();
		while(it.hasNext()) {
			String key = it.next();
			String value = paramMap.get(key)[0];
			map.put(key, value);
		}
		return map;
	}
}