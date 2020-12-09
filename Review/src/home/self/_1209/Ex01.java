package home.self._1209;

import java.util.ArrayList;

//컬렉션 프레임워크(Collections Framework)
//
public class Ex01 {
	
	public static void main(String[] args) {
		
	
	String[] array = new String[3];
	array[0] = "일";
	array[1] = "이";
	array[2] = "삼";
	//array[3] = '사'; array배열의 크기를 3으로 지정해줘서 그이상의 숫자가 들어가면 에러발생
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
	
	//1.ArrayList array2 = new ArrayList(); //어떤형태의 데이터타입도 수용할 수 있는 메소드 
	ArrayList<String> array2 = new ArrayList<String>(); //4.제네릭을 사용해서 바로 데이터타입 지정하면 형변환 필요x
	array2.add("one");//데이터를 추가 할 때 참조변수의 이름을 써주고 add메소드를 호출해서 써줘야 한다
	array2.add("two");//2. object는 모든 데이터타입의 조상이기 때문에 어떤 데이터도 수용하기위해서 인자의 데이터타입이 object여야 한다.
	array2.add("three");
	for (int i = 0; i < array2.size(); i++) {
		//3.String value =(String)array2.get(i);
		//그래서 변수가 String 타입이라면 get을 리턴하는 값이 object타입이므로 String으로 강제 형변환을 시켜줘야 한다.
		String value = array2.get(i);  
		System.out.println(value);
		System.out.println(array2.get(i));
		//배열의 길이 대신에 get이라는 메소드를 호출해서 저장한 값을 가져올 수 있다
	}
	}
	
		
}
