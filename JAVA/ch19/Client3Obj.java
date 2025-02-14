package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3Obj {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		InputStream is = null;
		ObjectInputStream ois = null;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			TCPObj obj = new TCPObj();
			System.out.println("name : ");
			obj.setHostName(sc.nextLine());
			System.out.println("message : ");
			obj.setMessage(sc.nextLine());
			
			socket = new Socket("127.0.0.1", 54321);
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			
			oos.writeObject(obj);						//메세지 전송
			
			TCPObj obj2 = (TCPObj) ois.readObject();	//보낸 메세지 받기
			System.out.println(obj2.toString());
			
			oos.close();
			os.close();
			ois.close();
			is.close();	//스트림들 받고
			
			socket.close();	//소켓도 닫음
		}//while
	}

}
