package ch18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferedTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:/URECA/JAVA/java_250120/src/ch18/han.txt");
		
		InputStreamReader isr = new InputStreamReader(fis);//보조스트림 연결
		BufferedReader br = new BufferedReader(isr);		//보조스트림에 보조스트림 연결
		
		long milli1 = System.currentTimeMillis();
		
		int readInt = 0;
		while((readInt = br.read()) != -1) {		
			System.out.print((char)readInt);
		}
		
		long milli2 = System.currentTimeMillis();
		System.out.println();
		System.out.println(milli2-milli1);
		
		br.close();
		isr.close();
		fis.close();
		
	}

}
