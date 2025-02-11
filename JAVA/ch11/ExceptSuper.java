package ch11;

import java.io.IOException;

public class ExceptSuper {
	public void name() throws IOException{		//throws를 한 메소드는 상속할때 어떻게 해야할까?
		new IOException();
	}
}
