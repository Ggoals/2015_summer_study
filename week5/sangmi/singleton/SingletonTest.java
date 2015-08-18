package singleton;

class Singleton{
	
	private static Singleton single; 
	
	//생성자는 private으로 접근을 막는다.
	private Singleton(){
	}
	
	public static Singleton getInstance(){ 
		if(single == null){
			single = new Singleton();
		}
		//멀티쓰레드 사용시 동기화문제 발생 -> 정적초기화 방법 구현
		//if(single==null) 부분에서 컨텍스트스위칭 발생
		//다른쓰레드에서 또 if(single==null)부분을 돌려버리면 객체 두개 생성.
		return single;
	}
}

public class SingletonTest{
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}
//Singleton 클래스에 single이라는 static 변수를 두고 
//getInstance메소드에서 single값이 null인 경우에만 객체를 생성하도록 하여 single객체가 단 한번만 만들어지도록함
//최초 getInstance가 호출되면 single이 null이므로 new에 의해서 객체 생성
//한 번 생성이되면 single은 static 변수이므로 그 이후로는 null이 아니게 된다.
//다시 getInstance 메소드가 호출되면 single은 null이 아니므로 이미 만들어진 싱글톤 객체인 single을 항상 리턴.
