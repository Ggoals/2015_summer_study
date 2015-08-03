package Four.Week;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class code_1370 {
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		List<Meeting> meetings = new ArrayList<Meeting>();
		
		for(int i = 0; i< count; i++) {
			meetings.add(new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt()) );
		}
		
		meetings.sort(new EndTimeAscCompare());
		
		List<Meeting> availableMeetings = new ArrayList<Meeting>();
		
		
		availableMeetings.add(meetings.get(0));
		int availableMeetingCount = 1;
		
		for(int i = 1; i < meetings.size(); i++) {
			if(meetings.get(i).startTime >= availableMeetings.get(availableMeetingCount - 1).endTime) {
				availableMeetings.add(meetings.get(i));
				availableMeetingCount++;
			}
		}
		
		System.out.println(availableMeetingCount);
		
		for(int i = 0; i < availableMeetings.size(); i++) {
			System.out.print(availableMeetings.get(i).index + " ");
		}
		
		sc.close();
	}
	
	
	
	public static class Meeting {
		public int index;
		public int startTime;
		public int endTime;
		
		public Meeting(int i, int s, int e) {
			this.index = i;
			this.startTime = s;
			this.endTime = e;
		}
	}
	
	public static class EndTimeAscCompare implements Comparator<Meeting> {
		 
		/**
		 * 오름차순(ASC)
		 */
		@Override
		public int compare(Meeting arg0, Meeting arg1) {
			// TODO Auto-generated method stub
			return arg0.endTime - arg1.endTime;
		}

	}
}




