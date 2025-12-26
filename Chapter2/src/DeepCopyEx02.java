import java.util.Arrays;

public class DeepCopyEx02 {
	
	public static void deepCopy1(int[][] a, int[][] b) {
		// arraycopy(a, 0, b, 0, a.length)는
		// 2차원 배열 a의 행의 주소를 b로 복사
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println("deep copy #1");
		b[0][0] = 10;
		printArray(a);
		printArray(b);
	}
	
	public static void deepCopy2(int[][] a, int[][] b) {
		for(int i=0; i<a.length; i++) {
			//2차원 배열 a[][]를 행 단위(a[i])로 복사
			System.arraycopy(a[i], 0, b[i], 0, a[i].length);
		}
		System.out.println("deep copy #2");
		b[0][0] = 10;
		printArray(a);
		printArray(b);
	}
	
	public static void printArray(int[][] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] b = new int[3][3];
		int[][] c = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] d = new int[3][3];
		deepCopy1(a, b);
		deepCopy2(c, d);
	}
}
