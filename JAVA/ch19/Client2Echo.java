package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2Echo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 54321); //서버 주소(내 컴퓨터랑 하니 루프백 주소로)와 서버 소켓을 통해 소켓 객체 생성

		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);//이걸 ObjectOutputStream으로 바꾸면 객체도 주고 받을 수 있음
		
		dos.writeUTF("from client.......");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);	
		
		String message = dis.readUTF();	//보낸 메세지 받기
		System.out.println(message);
		
		dos.close();
		os.close();
		dis.close();
		is.close();	//스트림들 받고
		
		socket.close();	//소켓도 닫음
	}

}
