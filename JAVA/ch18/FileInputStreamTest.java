package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:/URECA/JAVA/java_250120/src/ch15/db.properties");
		
		FileOutputStream fos = new FileOutputStream("C:/URECA/JAVA/java_250120/src/ch18/outtest.txt");
		
	
		int readInt = 0;
		while((readInt = fis.read()) != -1) {
			System.out.print((char)readInt);
			fos.write(readInt);
		}
		fos.close();
		fis.close();
		
		
		
		FileReader fr = new FileReader("C:/URECA/JAVA/java_250120/src/ch18/han.txt");
		
		FileWriter fw = new FileWriter("C:/URECA/JAVA/java_250120/src/ch18/hancopy.txt");
		int readInt2 = 0;
		while((readInt2 = fr.read()) != -1) {
			System.out.print((char)readInt2);
			fw.write(readInt2);
		}
		fw.close();
		fr.close();
		
	}

}













