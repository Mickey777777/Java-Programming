import java.io.*;
public class FileReadKorean {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("./hangul_ms949.txt");			
			in = new InputStreamReader(fin, "EUC-KR");	// 문자 스트림 클래스
			
			//fin = new FileInputStream("./hangul_utf8.txt");
			//in = new InputStreamReader(fin, "UTF-8");	// 문자 스트림 클래스
			int c;
					
			System.out.println("Encoding charset: " + in.getEncoding());
			
			while((c=in.read())!= -1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
