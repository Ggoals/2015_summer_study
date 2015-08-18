package singleton;


class Singleton3{
	//private static Singleton3 single;
	
	//정적초기화를 통해 안정적으로 한개의 객체만을 생성
	private static Singleton3 single = new Singleton3(); 
	
	//생성자는 private으로 접근을 막는다.
	private Singleton3(){
	}	
	public static Singleton3 getInstance(){ 
		//항상 인스턴스가 있으니 무조건 리턴(동기화 처리 필요없음)
		return single;
	}
}
public class SingletonTest3 {
	
	public class MyThread implements Runnable{
		
		//private String name;
		private Singleton3 sgt;
		
		//생성자에서 싱글톤 객체를 초기화
		public MyThread(String name){
						
			sgt = Singleton3.getInstance();
		}
		
		@Override
		public void run(){
			System.out.println("스레드!!");
		}
	}
	public static void main(String[] args) {

		SingletonTest3 sdt = new SingletonTest3();
		int threadCount = 5;
		
		for(int i = 0; i<threadCount ; i++){
			Thread t = new Thread(sdt.new MyThread("Thread"+i));
			t.run();
		}
	}
}