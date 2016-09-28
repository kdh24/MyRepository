package ch15.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;		// 최고 점수를 받은 아이디 저장
		int maxScore = 0;		// 최고 점수 저장
		int totalScore = 0;		// 점수 합계 저장
		
		//작성 위치
		Set<Entry<String, Integer>> entryset = map.entrySet();
		Iterator<Entry<String, Integer>> iterator = entryset.iterator();
		
		while(iterator.hasNext()){
			Entry<String, Integer> entry = iterator.next();
			String id = entry.getKey();
			int num = entry.getValue();
			
			if(num > maxScore){
				maxScore = num;
				name = id;
			}
			totalScore += num;
		}
		System.out.println("평균점수: " + totalScore/entryset.size());
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 아이디: " + name);
	}

}
