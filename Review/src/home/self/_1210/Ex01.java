package home.self._1210;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01 {
//LIST - 입력한 모든 값이 저장된다 (ArrayList, Vector, LinkedList)
//SET - 중복되는 값은 저장되지 않는다 	(HashSet, LinkedHashSet, TreeSet)
	public static void main(String[] args) {
		HashSet<Integer> hash = new HashSet<Integer>();
		//HashSet - 중복되는 값은 생략이 되고 출력된다.
		hash.add(1111);
		hash.add(1111);
		hash.add(2222);
		hash.add(2222);
		hash.add(2222);
		hash.add(3333);
		hash.add(4444);
		hash.add(5555);
	
		Iterator ite = (Iterator) hash.iterator();
		while(ite.hasNext()){
		System.out.println(ite.next());
		}
	}

}
