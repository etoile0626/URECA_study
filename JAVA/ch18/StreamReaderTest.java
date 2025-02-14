package ch18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamReaderTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:/URECA/JAVA/java_250120/src/ch18/han.txt");
		
		InputStreamReader isr = new InputStreamReader(fis);//보조스트림 연결
		
		int readInt = 0;
		while((readInt = isr.read()) != -1) {		//fis 대신에 isr을 넣어 한글 출력을 돕고있음 
			System.out.print((char)readInt);
		}
		fis.close();
	}

}
