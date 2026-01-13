import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class SerializationEx02 {
    String fileName = "userinfo.out";    
    public SerializationEx02() {}
    
    public void writeUserInfoObject() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            UserInfo u1 = new UserInfo("Alice", "1234", 21);
            UserInfo u2 = new UserInfo("Bob", "5678", 22);
            ArrayList<UserInfo> list = new ArrayList<UserInfo>();

            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);

            out.close();
            fos.close();            
            System.out.printf("UserInfo 객체 %s 파일로 저장\n\n", fileName);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readUserInfoObject() {
        System.out.println("Read user info object");
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            // 객체를 읽을 때, 저장 순서와 동일한 순서로 읽음
            UserInfo u1 = (UserInfo)in.readObject();
            UserInfo u2 = (UserInfo)in.readObject();
            ArrayList<UserInfo> list = (ArrayList<UserInfo>)in.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);

            in.close();
            fis.close();            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SerializationEx02 ex = new SerializationEx02();
        ex.writeUserInfoObject();
        ex.readUserInfoObject();
    }
}
