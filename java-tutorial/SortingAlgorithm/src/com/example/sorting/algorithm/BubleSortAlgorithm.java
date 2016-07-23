package com.example.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author merku
 */
public class BubleSortAlgorithm {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(5);
		list.add(6);
		list.add(3);
		list.add(1);
		list.add(0);
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(100);
		list1.add(19);
		list1.add(123);
		list1.add(145);
		list1.add(89);
		list1.add(5);
		list1.add(1);
		list1.add(3);
		list1.add(1);
		list1.add(0);

		SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
		sortingAlgorithm.bubleSort(list);
		sortingAlgorithm.selectionSort(list1);
	}
}

class SortingAlgorithm {

	public void bubleSort(List<Integer> list) {
		// 5,1,12,-5,16
		int counter=0;
		for (int i = 0; i < list.size(); i++) {
			int k;
			for (int j = 0; j < list.size()-1; j++) {
				
					k=j+1;
					if(list.get(j)>list.get(k)){
						int bufferedValue=list.get(k);
						list.set(k, list.get(j));
						list.set(j, bufferedValue);
						counter++;
					}	
					
			}
			printNumbers(list,"bubleSort");
		}
		System.out.println("Counter:"+counter);
	}
	
	public void selectionSort(List<Integer> list) {
		// 5,1,12,-5,16
		int counter=0;
		for (int i = 0; i < list.size()-1; i++) {
			
			int index=i;
			
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(j)<list.get(index)){
					index=j;
					counter++;
				}
			}
			
			int lowest=list.get(index);
			list.set(index, list.get(i));
			list.set(i, lowest);
			
			printNumbers(list,"selectionSort");
		}
		System.out.println("Counter:"+counter);
	}
	
	private void printNumbers(List<Integer> list,String algorithmName){
		System.out.println("Sorting Algorithm Name:"+algorithmName);
		
		for (Integer integer : list) {
			System.out.print(integer+",");	
		}
		System.out.println("");
	}
}
