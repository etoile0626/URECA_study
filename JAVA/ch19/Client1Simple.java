package ch19;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1Simple {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 54321); //서버 주소(내 컴퓨터랑 하니 루프백 주소로)와 서버 소켓을 통해 소켓 객체 생성

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		String message = dis.readUTF();	//보낸 메세지 받기
		System.out.println(message);
		
		dis.close();
		is.close();	//스트림들 받고
		
		socket.close();	//소켓도 닫음
	}

}
