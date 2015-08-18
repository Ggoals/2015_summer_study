package singleton;

class Singleton2 {
	private Singleton2(){		
	}
	
	public static Singleton2 getInstance(){
		return new Singleton2();
	}

}

public class SingletonTest2{
	public static void main(String[] args) {
		Singleton2 singleton1 = Singleton2.getInstance();
		Singleton2 singleton2 = Singleton2.getInstance();
		
		System.out.println(singleton1 == singleton2);
	}
}

//getInstance 라는 static 메소드를 이용하여 Singleton객체를 돌려받을 수 있음
//하지만 getInstance를 호출할 때 마다 새로운 객체 생성 -> 싱글톤 아님!