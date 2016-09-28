package ch15.exam05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		//점수 찾기
		int firstScore = scores.first();
		System.out.println(firstScore);
		System.out.println();
		
		int lastScore = scores.last();
		System.out.println(lastScore);
		System.out.println();
		
		int lowerScore = scores.lower(90);
		System.out.println(lowerScore);
		System.out.println();
		
		int higherScore = scores.higher(95);
		System.out.println(higherScore);
		System.out.println();
		
		int floorScore = scores.lower(95);
		System.out.println(floorScore);
		System.out.println();		
		
		int ceilingScore = scores.ceiling(95);
		System.out.println(ceilingScore);
		System.out.println();
		
		//정렬
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer score : descendingSet){
			System.out.print(score + ",");
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer score : ascendingSet){
			System.out.print(score + ",");
		}
		System.out.println();
		
		//범위 검색
		TreeSet<String> words = new TreeSet<>();
		words.add("apple");
		words.add("forever");
		words.add("description");
		words.add("ever");
		words.add("zoo");
		words.add("base");
		words.add("guess");
		words.add("cherry");
		NavigableSet<String> ns = words.descendingSet().descendingSet();
		for(String word : ns){
			System.out.print(word + ",");
		}
		System.out.println();
		
		NavigableSet<String> ns2 = words.subSet("c", true, "f", true);
		for(String word : ns2){
			System.out.print(word + ",");
		}
		System.out.println();
	}
}
