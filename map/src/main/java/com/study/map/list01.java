package com.study.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 将1-100之间的所有正整数存放在一个List集合中，并将集合中索引位置是10的对象从集合中移除
 * 
 * @author Light
 *
 */
public class list01 {
	

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i < 100; i++){
			list.add(i);
		}
		list.remove(10);
		for(Integer l:list){
			System.out.print(l+",");
		}
		System.out.println();
		for(int j=0;j<list.size()-1;j++){
			System.out.print(list.get(j)+",");
		}
		System.out.print(list.get(list.size()-1));

	}

}
