package sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
	
public class WriteExample {
	public static void main(String[] args) {
		try {
			//OutputStream os = new FileOutputStream("test3.db");
			OutputStream os = new FileOutputStream("stest3.db");
			
			byte[] array = { 10, 20, 30, 40, 50 };

			os.write(array, 1, 3);
			//os.write(array);
			
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}