package ch05;

import java.util.Calendar;

public class WeekExam {

	public static void main(String[] args) {
		Week week = null;
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.DAY_OF_WEEK;
		
		switch(dayOfWeek) {
		case 1:	week = Week.SUNDAY;		break;					//enum 활용
		case 2:	week = Week.MONDAY;		break;
		case 3:	week = Week.TUESDAY;	break;
		case 4:	week = Week.WEDNESDAY;	break;
		case 5:	week = Week.THURSDAY;	break;
		case 6:	week = Week.FRIDAY;		break;
		case 7:	week = Week.SATURDAY;	break;
		}
		
		if(week == Week.MONDAY) {						//enum 활용
			System.out.println("오늘은 월요일 입니다.");
		}

	}

}
