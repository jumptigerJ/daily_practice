package com.study.list;

import java.util.ArrayList;
import java.util.Random;

public class list {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			Random r = new Random();
			int temp = r.nextInt(100);
			list.add(temp);
		}
		
		for (int i = 0; i < list.size()-1; i++)
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(j) < list.get(i)){
					Integer temp;
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		
		for(Integer i:list){
			System.out.print(i+",");
		}

	}
}
