
public class SimpleGenericEx {

	public static void main(String[] args) {
		MyClass<String> m1 = new MyClass<>();
		m1.set("hello");
		System.out.println(m1.get());
		
		MyClass<Integer> m2 = new MyClass<>();
		m2.set(100);
		System.out.println(m2.get());

	}

}
