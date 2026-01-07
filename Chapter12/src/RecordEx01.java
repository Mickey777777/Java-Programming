
public class RecordEx01 {

	public static void main(String[] args) {
		Staff s1 = new Staff("Alice", 30, "alice1@email.com");
		Staff s2 = new Staff("Alice", 30, "alice2@email.com");
		Staff s3 = new Staff("Bob", 25, "bob@email.com");
		
		System.out.println("name: " + s1.name());
		System.out.println("age: " + s1.age());
		System.out.println(s1);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		Staff s4 = new Staff("Bob", 25, "bob@email.com");
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
	}

}
