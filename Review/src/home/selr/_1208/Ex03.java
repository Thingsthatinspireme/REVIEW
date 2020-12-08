package home.selr._1208;

abstract class Volume{
	//interface를 사용해서 implements해도됨 그래도 똑같이 제네릭에서는extends사용
	public abstract int getUP();
	public abstract int getDown();
}

class Tv extends Volume{

	public int plus;
	public int minus;
	
	Tv(int plus, int minus){

		this.plus = plus;
		this.minus = minus;
	}

	public int getUP() {
		return plus;
	}

	
	public int getDown() {
		return minus;
	}

}

class Model<T extends Volume>{
//T에 오게하고싶은 데이터 타입은 Volume이나 Volume의 자식 클래스들만 가능하게 하고싶을때 extends를 사용해준다
	public T name;
	Model(T name){this.name = name;}
}

public class Ex03 {

	public static void main(String[] args) {
		Model<Tv>model = new Model<Tv>(new Tv(1, 2));
		
		//Model <String> name = new Model <String>("tv-123");  
        //데이터타입이 Volume이나 그 자식클래스인 Tv가 아니라서 컴파일에러가뜸 
		
	}

}
