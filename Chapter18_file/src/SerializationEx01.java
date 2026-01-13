import java.io.*;
import java.util.Date;

public class SerializationEx01 {
    public static void main(String[] args) throws IOException{
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            // Date 객체를 파일에 저장
            out = new ObjectOutputStream(new FileOutputStream("object.dat"));
            out.writeObject(new Date()); // IOException 발생

            // 파일에서 Date 객체를 읽어옴
            in = new ObjectInputStream(new FileInputStream("object.dat"));
            Date d = (Date) in.readObject(); // ClassNotFoundException 발생
            System.out.println(d);
        } catch(IOException e) {
            System.out.println("IOException" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException 발생 ");
        }finally {
            in.close(); 
            out.close();
        }
    }
}