import java.util.Arrays;

public class DeepCopyEx01 {

	public static void main(String[] args) {
		int intArray[] = {1, 2, 3, 4, 5};
		// Arrays.copyOf(원본, 원본배열 길이)
		int myArray[] = Arrays.copyOf(intArray, intArray.length);
		
		myArray[0] = 10;
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(myArray));
		
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		// System.arraycopy(원본배열, 원본 시작 위치, 타겟배열, 타겟 배열 위치, 복사할 길이)
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		newStrArray[2] = "deepcopy";
		System.out.println(Arrays.toString(oldStrArray));
		System.out.println(Arrays.toString(newStrArray));
		
	}

}
