import java.util.Vector;

public class VectorEx02 {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		
		System.out.printf("1.size: %2d, Capacity: %2d\n", vector.size(), vector.capacity());
		
		int i;
		for(i=0; i<10; i++) {
			vector.add(i+1);
		}
		
		System.out.printf("2.size: %2d, Capacity: %2d\n", vector.size(), vector.capacity());
		
		vector.add(i+1);
		System.out.printf("3.size: %2d, Capacity: %2d\n", vector.size(), vector.capacity());
		System.out.println();
		
		for(Integer n : vector) {
			System.out.print(n + " ");
		}

	}

}
