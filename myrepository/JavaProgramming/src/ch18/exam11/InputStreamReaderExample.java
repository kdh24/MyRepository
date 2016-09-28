package ch18.exam11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		
		/*byte[] values = new byte[100];
		int byteNum = is.read(values);
		String data = new String(values, 0, byteNum-2);
		System.out.println(data);*/
		
		Reader reader = new InputStreamReader(is);
		char data =(char) reader.read();
		System.out.println(data);
	}

}
