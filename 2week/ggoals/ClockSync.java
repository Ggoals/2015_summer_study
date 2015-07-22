import java.util.Scanner;

public class ClockSync {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = Integer.parseInt(sc.nextLine());
		int arr[][] = new int[count][16];
		
		for(int i = 0 ; i < count; i++) {
			for(int j = 0; j < 16; j++) {
				arr[i][j] = Integer.parseInt(sc.next());
			}
		}
		
		for(int i= 0; i < count; i++) {
			
			for(int j = 0;j < arr[i].length; j++) {
				arr[i][j] = arr[i][j] / 3 % 4;
			}
			
			ClockCountSync cc = new ClockCountSync(arr[i]);
			System.out.println(cc.getMinCount());
		}
		sc.close();
	}
	
	static class ClockCountSync {
		private int clocks[];
		private int switches[][] = { 
					 {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
		             {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
		             {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
		             {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		             {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		             {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
		             {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
	             };
		public ClockCountSync() {
			
		}
		public ClockCountSync(int[] arr) {
			clocks = new int[16];
			clocks = arr;
		}
		
		private boolean _isValidClokcArr() {
			for(int i = 0; i < clocks.length; i++) {
				if(clocks[i] != 0)
					return false;
			}
			return true;
		}
		
		private void _clickSwitch(int index) {
			//System.out.println("click!! --> " + index);
			for(int i = 0; i < switches[index].length; i++) {
				clocks[i] += switches[index][i];
				if(clocks[i] == 4)
					clocks[i] = 0;
			}
		}
		
		private int _getPushedBtnCount(int arr[]) {
			int count = 0;
			
			for(int i = 0; i < arr.length; i++) {
				count += arr[i];
			}
			
			return count;
		}
		
		public int getMinCount() {
			int switchPushCountArr[] = new int[switches.length];
			
			int minCount = 100000;
			int currentIndex = 0;
			
			if(_isValidClokcArr()) {
				int _currentCount = _getPushedBtnCount(switchPushCountArr);
				if( minCount > _currentCount)
					minCount = _currentCount;
			}
			
			while(true) {
				if(currentIndex == switchPushCountArr.length) {
					break;
				}
				
				
				_clickSwitch(currentIndex);
				switchPushCountArr[currentIndex]++;
				
				while(true) {
					if(switchPushCountArr[currentIndex] == 4) {
						switchPushCountArr[currentIndex] = 0;
						if(currentIndex == switches.length - 1) {
							currentIndex++;
							break;
						}
											
						currentIndex++;
						switchPushCountArr[currentIndex]++;
						_clickSwitch(currentIndex);
					}else {
						currentIndex = 0;
						break;	
					}
				}
				
				
				/*System.out.print("[ ");
				for(int i = 0; i < switchPushCountArr.length; i++) {
					System.out.print(switchPushCountArr[i] + ",");
				}
				System.out.println(" ]");
				*/
				
				if(_isValidClokcArr() && currentIndex != switchPushCountArr.length) {
					int _currentCount = _getPushedBtnCount(switchPushCountArr);
					if( minCount > _currentCount)
						minCount = _currentCount;
				}
			}
			
			
			if(minCount == 100000)
				return -1;
			return minCount;
		}
	}
}

