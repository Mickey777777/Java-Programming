
public class HelloWorld {
	String name;
	
	public HelloWorld() {
		this.name = "Hello Java Version 2"; 
	}
	
	public void printName() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		hello.printName();
	}

}
