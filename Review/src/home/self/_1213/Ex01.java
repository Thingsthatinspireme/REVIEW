package home.self._1213;

import java.util.HashSet;
import java.util.Iterator;

//list는 인덱스(순서)가 존재하기 때문에 인덱스와 관련된 api를 가지고 있다
//set은 순서가 존재하지 않기 때문에 인덱스와 관련된 api를 가지고 있지 않다.
//컬렉션 인터페이스안에 들어있는 메소드만 사용하고 있다면 데이터타입을 컬렉션 인터페이스로만 하는게 좋다
//- 그러면 나중에 필요에 따라서 set과 list로 변경이 가능하다 


//컬렉션 인터페이스를 구현하는 모든 클래스들은 iterator(반복자 :하나하나 꺼내서 역할을 할 수 있게 해주는것) 라는 
//메소드를 통해서 반복자라는 것을 제공하도록 강제되어 있다
public class Ex01 {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);

		Iterator ite = A.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}

}
