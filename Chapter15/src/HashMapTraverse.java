
import java.util.*;

public class HashMapTraverse {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("A", 10);
		hashMap.put("B", 20);
		hashMap.put("C", 30);
		hashMap.put("D", 40);
		hashMap.put("E", 50);
		
		System.out.println("keySet() 사용 ");
		for(String key : hashMap.keySet()) {
			System.out.println("key: " + key + ", value: " + hashMap.get(key));
		}
		System.out.println();
		
		System.out.println("entrySet() 사용 ");
		for(HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
		System.out.println();
		
		Iterator<String> it = hashMap.keySet().iterator();
		System.out.println("Iterator 사용 ");
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("key: " + key + ", value: " + hashMap.get(key));
		}
		
		

	}

}
