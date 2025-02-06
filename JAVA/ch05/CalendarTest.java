package ch05;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {

		//Date date = new Date();						//요새는 잘 안쓰는 데이터 타입
		//System.out.println(date.getDate());			//권장하지 않는다고 줄 그어져있음
		
		Calendar calendar = Calendar.getInstance();		//calendar 객체 선언
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);	//0부터 11까지나와서 반드시 +1해야 이번 달이 나옴!! 
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));  //이번달에서 몇번째 날인지
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));  //이번주에서 몇번째 날인지(일요일이 1)
		System.out.println(calendar.get(Calendar.DATE)); 
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); 
		System.out.println(calendar.get(Calendar.MINUTE)); 
		System.out.println(calendar.get(Calendar.SECOND)); 
		
	}

}
