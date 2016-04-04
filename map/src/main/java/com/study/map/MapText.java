package com.study.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapText {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		Emp emp = new Emp("01","张三");
		Emp emp2 = new Emp("06","李四");
		Emp emp3 = new Emp("03","王二");
		Emp emp4 = new Emp("07","王三");
		Emp emp5 = new Emp("09","王五");
		Emp emp6 = new Emp("04","王六");
		
		map.put(emp.getId(), emp.getName());
		map.put(emp2.getId(), emp2.getName());
		map.put(emp3.getId(), emp3.getName());
		map.put(emp4.getId(), emp4.getName());
		map.put(emp5.getId(), emp5.getName());
		map.put(emp6.getId(), emp6.getName());
		
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		System.out.println("HashMap类实现的Map集合：无序：");
		while(it.hasNext()){
			String key = (String) it.next();
			String value = map.get(key);

			System.out.println(key + " " +value);
		}
		
		TreeMap<String,String> treeMap = new TreeMap<>();
		treeMap.putAll(map);
		Iterator iter = treeMap.keySet().iterator();
		System.out.println("TreeMap类实现的Map集合：键对象升序");
		while(iter.hasNext()){
			String key = (String) iter.next();
			String value = treeMap.get(key);
			System.out.println(key + "  "+value);
		}
	}

}
