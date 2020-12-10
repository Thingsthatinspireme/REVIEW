package home.self._1210;

import java.util.HashSet;
import java.util.Iterator;

public class Ex02 {

	public static void main(String[] args) {
		
		HashSet<Integer> hash1 = new HashSet<Integer>();
		hash1.add(1);
		hash1.add(2);
		hash1.add(3);
		hash1.add(4);
		hash1.add(5);
		
		HashSet<Integer> hash2 = new HashSet<Integer>();
		hash2.add(4);
		hash2.add(5);
		hash2.add(6);
		hash2.add(7);
		
		HashSet<Integer> hash3 = new HashSet<Integer>();
		hash3.add(1);
		hash3.add(3);
		hash3.add(5);
		
		System.out.println(hash1.containsAll(hash2));
		//hash1이 hash2의 내용을 다 포함하고 있는가? false
		System.out.println(hash1.containsAll(hash3));
		//hash1이 hash3의 내용을 다 포함하고 있는가? true
		
		System.out.println("------------------------");
		
		hash1.addAll(hash2);//합집합 - hash1과 hash2를 합친 1, 2, 3, 4, 5, 6, 7 이 출력
		
		Iterator ite = (Iterator) hash1.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
		System.out.println("------------------------");
		
		hash1.retainAll(hash2);//교집합 - hash1과 hash2의 공통원소인 4, 5 출력
		
		Iterator ite2 = (Iterator) hash1.iterator();
		while(ite2.hasNext()){
			System.out.println(ite2.next());
		}
		
		System.out.println("------------------------");
		
		hash1.removeAll(hash2);//차집합 - hash1과 hash2의 차집합인 1, 2, 3 출력
		
		Iterator ite3 = (Iterator) hash1.iterator();
		while(ite3.hasNext()){
			System.out.println(ite3.next());
		}
		
		
	}

}
