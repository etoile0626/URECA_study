package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3Obj {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//기본적인 TCP 통신
		ServerSocket ss = new ServerSocket(54321);			//54321 포트로 서버소켓 생성
		Socket socket = null;			//요청 올때 만들어줄거임
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;	
		System.out.println("server started...");
		
		while(true) {
			socket = ss.accept();	//대기하고 있다가 요청오면 바로 수락, 이때 소켓 객체가 만들어짐
			System.out.println("server accept.....");
			
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			os = socket.getOutputStream();	//소켓에서 output스트림 가져오고 (서버가 보내니까 서버 기준에서는 output)
			oos = new ObjectOutputStream(os);	//보조 스트림 붙여줌
			
			TCPObj obj = (TCPObj) ois.readObject();	//클라이언트로부터 먼저 메세지를 받아옴
			obj.setHostName("from server : "+obj.getHostName());
			System.out.println("Client Message: "+ obj.toString());
			
			oos.writeObject(obj);	//다시 클라이언트한테 받은 메세지 전송
			
			ois.close();
			is.close();
			oos.close();
			os.close();
			socket.close(); //해도 되려나?
		}

	}

}
