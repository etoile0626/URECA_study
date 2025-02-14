package ch19;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1Simple {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(54321);			//54321 포트로 서버소켓 생성
		Socket socket = null;			//요청 올때 만들어줄거임
		OutputStream os = null;
		DataOutputStream dos = null;	
		System.out.println("server started...");
		
		while(true) {
			socket = ss.accept();	//대기하고 있다가 요청오면 바로 수락, 이때 소켓 객체가 만들어짐
			System.out.println("server accept.....");
			
			os = socket.getOutputStream();	//소켓에서 output스트림 가져오고 (서버가 보내니까 서버 기준에서는 output)
			dos = new DataOutputStream(os);	//보조 스트림 붙여줌
			
			dos.writeUTF("server accept client request......");
			
			dos.close();
			os.close();
		}

	}

}
