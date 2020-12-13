package home.self._1213;

import java.util.HashMap;

//MAP - key와 value로 나누어져서 각각 데이터를 저장한다
//key값으로 one이라는 스트림을 주고 vlaue로는 1을주는 식으로 저장 할 수 있다
//나중에 one이라는 key값을 전달하면 1을 리턴해주는 방식이다
//key값은 중복이 허용되지 않는다. 하지만 value는 중복이 가능하다 

public class Ex02 {

	public static void main(String[] args) {
		HashMap<String, Integer> B = new HashMap<String, Integer>();
		       //key값, value값                                            key값, value값 
		B.put("one", 1); //(key값, value값)
		B.put("two", 2);
		B.put("three", 3);
		
		System.out.println(B.get("one")); //1 return
		System.out.println(B.get("two")); //2 return
		System.out.println(B.get("three")); //3 return
	}

}
