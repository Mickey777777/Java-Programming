
public class IndexOfContainsExample {

	public static void main(String[] args) {
		String subject = "자바 프로그래밍 자바";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		String subString = subject.substring(location);
		System.out.println(subString);
		
		String keyword = "자바";
		location = subject.indexOf(keyword);
		if(location != -1) {
			System.out .println("index of 자바: " + location);
		} else {
			System.out .println("\"자바\" 단어가 없습니다.");
		}
		
		int nextLocation = subject.indexOf(keyword, location + keyword.length());
		System.out .println("다음 검색 위치: " + nextLocation);
		
		boolean result = subject.contains("자바");
		if(result) {
			System.out .println("\"자바\" 단어를 포함하고 있습니다.");
		}else {
			System.out .println("\"자바\" 단어를 포함하고 있지 않습니다.");
		}
	}

}
