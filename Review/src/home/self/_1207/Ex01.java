package home.self._1207;
//제네릭 (Generic) - 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
//타입이 안전하다는 장점과 코드의 중복을 제거하는 편의성을 한번에 같이 가져가기위한 기법
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
}


public class Ex01 {

	public static void main(String[] args) {
		
		B<A, int> p1 = new B<A, int>(new A(1), id);
		//데이터 타입을 따로 지정해주지 않고 인스턴스화 시킬 때 지정해준다.
	
		
	}

}
