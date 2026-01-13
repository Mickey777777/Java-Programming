import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx01 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("test.txt");
			
			while(true) {
				int data;				
				data = is.read();				
				if(data == -1) // -1을 리턴할 경우, while 문 종료
					break;
				
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
