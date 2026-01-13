package sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			//OutputStream os = new FileOutputStream("C:/Temp/test1.db");
			OutputStream os = new FileOutputStream("test1.db"); // 프로젝트 폴더 아래에 생성 
				
			byte a = 10;
			byte b = 20;
			byte c = 30;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush(); // OutputStream에서 flush()는 아무 동작 없음 
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}