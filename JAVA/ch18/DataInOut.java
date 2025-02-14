package ch18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOut {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/URECA/JAVA/java_250120/src/ch18/dataout.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(77777);
		dos.writeBoolean(false);
		dos.writeDouble(3.14);
		dos.writeUTF("nice to meet you");
		
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/URECA/JAVA/java_250120/src/ch18/dataout.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		
		dis.close();
		fis.close();
	}

}
