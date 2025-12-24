import java.util.Scanner;

public class ScannerNextLineEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String str1 = scanner.next();
		System.out.println(str1);
		
		scanner.nextLine();
		
		System.out.print("Enter a single line of string: ");
		String lineString = scanner.nextLine();
		System.out.println(lineString);
		
		scanner.close();
		System.out.println("Exit Program");
	}
}
