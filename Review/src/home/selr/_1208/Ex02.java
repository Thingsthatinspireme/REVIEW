package home.selr._1208;

import home.self._1207.A;
import home.self._1207.B;

//제네릭의 생략 - 제네릭은 생략이 가능하다. 

class A{
	public int rank;
	A(int rank) {this.rank = rank;}
}

class B<T, S>{
	public T info;
	public S id;
	B(T info, S id){
		this.info = info;
		this.id = id;
	}
	
	
	public <U> void c(U info){
		System.out.println(info);
	}//제네릭은 메소드에서도 사용이 가능하다 . 매개변수의 데이터 타입을 아직 정해주고 싶지 않을 때 제네릭을 이용
	 //메소드가 반환할 데이터 타입을 지정해주지 않으면 된다.
}




public class Ex02 {

	public static void main(String[] args) {
		A a = new A(1);
		Integer i = new Integer(10);
		//B<A, Integer> p1 = new B<A, Integer>(new A(1), id); 
		B p1 = new B(a, i);
	    //어떤 참조데이터타입이 들어가는지 생략이 가능하다. 변수에 들어가는 데이터 타입이 이미 위쪾의 코드에
		//서술되었기 떄문이다.(a는 A형, i는 Integer로 서술되었기 때문에 생략가능)
		
		
		//p1.<A>c(a); 이렇게 설정해주면 A타입의 a가 메소드 c로 전달되게되서 메소드 c의 타입은 A가된다.
		p1.c(a); //이렇게 생략해서 써줘도 어차피 a의 타입은 A이기 때문에 똑같은 결과가 나온다.
	
	}

}