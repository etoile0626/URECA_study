package ch18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInOutTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/URECA/JAVA/java_250120/src/ch18/obj.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new ObjectInOut("유재석", 18));
		oos.writeObject(new ObjectInOut("강호동", 19));
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/URECA/JAVA/java_250120/src/ch18/obj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			ObjectInOut temp = null;
			while((temp = (ObjectInOut) ois.readObject()) != null) {
				System.out.println(temp.toString());
			}
		}finally {
			System.out.println();
		}
		ois.close();
		fis.close();

	}

}
