package ch19;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TCPObj implements Serializable{	//Serializable이 없으면 통신을 못함
	private String hostName;
	private String message;
	@Override
	public String toString() {
		return this.hostName + " : "+ this.message;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
