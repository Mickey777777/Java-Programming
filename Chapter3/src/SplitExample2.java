
public class SplitExample2 {

	public static void main(String[] args) {
		String str1 = "boo:and:foo";
		String[] splited1 = str1.split(":");
		for(int i=0; i<splited1.length; i++) System.out.println(splited1[i]);
		System.out.println();
		
		String str2 = "aaa bbb ccc";
		String[] splited2 = str2.split(" ");
		for(int i=0; i<splited2.length; i++) System.out.println(splited2[i]);
		System.out.println();
		
		String str3 = "Hello,world;Java Programming";
		String[] splited3 = str3.split(",|;| ");
		for(int i=0; i<splited3.length; i++) System.out.println(splited3[i]);
		System.out.println();
				

	}

}
