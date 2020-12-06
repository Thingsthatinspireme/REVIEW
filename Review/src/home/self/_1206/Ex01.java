package home.self._1206;

class A{
	
	public int i;
	
	A(int i){
		this.i = i;
	}
}


public class Ex01 {

	public static void copy1() {
		int a = 1;
		int b = a;//기본 데이터 타입이라서 복제가 일어남
		b = 2;
		System.out.println("copy1 복사  a : " + a );
	
	}

	public static void reference1(){
		
		A a = new A(1);
		A b = a;//참조형 데이터타입이라서 객체의 주소를 전달해줌
		b.i = 2;//전달된 객체의 주소를 가지고 객체의 내용을 수정 - 원본의 데이터가 모든 참조데이터형에 반영 
		        //결국 객체는 하나이기 때문에 인스턴스를 여러개만들어도 주소만 받으면 되니까 
		        //적은양의 메모리를 사용할 수 있다
		System.out.println("reference1 참조  a.i : " + a.i);
	}
	
	
	public static void copy2_2(int d){
		d = 2; //int d에 2를 넣어주는거라서 c에 영향이 없음
	}
	
	public static void copy2(){
		int c = 1;
		copy2_2(c);//호출한 메소드에 1을 전달해줌
		System.out.println("copy2 복제2 c : " + c); //1출력
	}
	
	
	public static void reference2_2(A d){
		d = new A(2);//d를 참조변수로 사용해서 새로운 인스턴스를 만든거라서 c에 영향x
	}
	
	public static void reference2(){
		A c = new A(1);//c를 참조변수로 새로운 인스턴스 생성 
		reference2_2(c);//호출한 메소드에 생성된 객체 A의 주소값 전달 
		System.out.println("reference2 참조2 c.i : " + c.i);//1출력
	}
	
	
	public static void reference3_2(A d){
		d.i = 2; //그 주소값을 그대로 받아서 객체 A의 생성자 호출 i의 값이 바뀜  
	}
	
	
	public static void reference3(){
		A c = new A(1);//객체 A생성
		reference3_2(c);//호출한 메소드에 객체 	A의 주소값 전달
		System.out.println("reference3 참조3 c.i : " + c.i);//2출력
	}
	
	
	public static void main (String[] args){
		copy1();
		reference1();
		copy2();
		reference2();
		reference3();
	}
	
	
	
}
