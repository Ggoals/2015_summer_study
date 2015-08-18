package singleton;

class Singleton1 {
	
	private Singleton1(){
		
	}
}

public class SingletonTest1{
	public static void main(String[] args) {
		Singleton1 singleton = new Singleton1();
	}
}


//compile 에러 발생 
//Singleton 클래스의 생성자에 private 키워드로 외부 클래스에서 
//Singleton 클래스의 생성자로의 접근을 막았기 때문
//생성자를 private으로 만들면 외부 클래스에서 Singleton클래스의 new를 이용하여 생성할 수 없다.
//new를 이용하여 무수히 많은 객체를 생성하면 싱글톤의 정의에 어긋나므로 생성할 수 없게 막은 것.