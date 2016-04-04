package com.study.list;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * 随机生成50个小于100的整数，放入List中，将List中的数据除以10，以结果的整数值作为key放入Map中，得到如下
 * {1=>[11,10,12],2>=[21,24,23]}的Map,再将Map中的key对应的数组进行排序，得到如下
 * {1=>[10,11,12],2>=[21,23,24]}
 * 
 * 输出的形式如下： 随机生成50个小于100的数，分别为：xxx,xxx,xxx
 * Map中的数据为：{1=>[11,10,12],2>=[21,24,23]} 排序后的Map为：{1=>[10,11,12],2>=[21,23,24]}
 * 
 * @author youyan
 *
 */
public class Test {

	private ArrayList<Integer> alist;
	private ArrayList<Integer> e;
	private HashMap<Integer, ArrayList<Integer>> map;
    

	
	public void printMap(){
		map=this.sortMap();
		System.out.println(map);
	}
	
	/**
	 * 对list进行从小到大排序
	 * @param e
	 * @return
	 */
	private ArrayList<Integer> sortList(ArrayList<Integer> e){
		Collections.sort(e);
		return e;
	}
	

	private HashMap<Integer, ArrayList<Integer>>  sortMap(){
		map=this.setMap();
		for (Integer i : map.keySet()) {
			e= map.get(i);
			e=this.sortList(e);
			map.put(i, e);
			
		}
		
		return map;
	}
	/**
	 * 将50个数分组插入map中
	 * @return
	 */
	private HashMap<Integer, ArrayList<Integer>> setMap() {
		map = new HashMap<>();
		alist = this.setList();
		Integer k,v;
		
		for (int i = 0; i < alist.size(); i++) {
			v=alist.get(i);
			k = v % 10;
			if (!map.containsKey(k)) {
                e=new ArrayList<>();
                e.add(v);   
              
			}else{
				e=map.get(k);
				e.add(v);
			
			}
			map.put(k, e);
		}
		return map;

	}

	/**
	 * 随机生成50个小于100的整数，放入List中
	 * 
	 * @return
	 */
	private ArrayList<Integer> setList() {

		ArrayList<Integer> alist = new ArrayList<Integer>();

		Random num = new Random(100);
		for (int i = 0; i < 50; i++) {
			Integer e = num.nextInt(100);
			alist.add(e);
		}
		return alist;

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.printMap();
	}
}
