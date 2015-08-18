package singleton;

class SingletonDCL3{
	
	private volatile static SingletonDCL3 single;
	//volatile : 어떤 스레드가 값을 변경하든 항상 최신값을 읽어갈 수 있게 해줌.
	//자바 5 버전 이상이면, volatile을 사용해야함. (사용하지 않으면 변수의 원자성 보장이 안됨.)
	
	//생성자 접근 제한
	private SingletonDCL3(){
	}
		
	//DCL구현
	public static SingletonDCL3 getInstance(){ 
		

		//모든 코드를 동기화하는 경우 부하가 크기 때문에 인스턴스가 생성된 경우에는 동기화 블록에 들어가지  않도록함.
		//이를 위해 두 번의 검사를 하기 때문에 DCL이라함.
		if(single == null){ //1차 LOCK
			
			//처음에만 동기화를 진행(오버헤드 발생X)
			synchronized(SingletonDCL3.class){
			if(single == null){
				single = new SingletonDCL3(); 
				//volatile을 사용하지 않으면 변수 공간만 생성하고 초기화를 나중에 하는 경우 발생
				//single이 null이 아니지만 생성자가 호출되지 않게 된다.
				
			}
		}
		}
		return single;
	}
}

public class SingletonDCLTest3 {
	
	public class MyThread implements Runnable{
		
		//private String name;
		private SingletonDCL3 sgt;
		
		//생성자에서 싱글톤 객체를 초기화
		public MyThread(String name){
						
			sgt = SingletonDCL3.getInstance();
		}
		
		@Override
		public void run(){
			System.out.println("스레드!!");
		}
	}
	public static void main(String[] args) {

		SingletonDCLTest3 sdt = new SingletonDCLTest3();
		int threadCount = 5;
		
		for(int i = 0; i<threadCount ; i++){
			Thread t = new Thread(sdt.new MyThread("Thread"+i));
			t.run();
		}
	}
}

