
public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone mySmartPhone = new SmartPhone("갤럭시", "은색");
		
		System.out.println("모델: " + mySmartPhone.model);
		System.out.println("색상: " + mySmartPhone.color);
		
		System.out.println("와이파이 상태: " + mySmartPhone.wifi);
		
		mySmartPhone.bell();
		mySmartPhone.sendVoice("여보세요.");
		mySmartPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		mySmartPhone.sendVoice("아~ 네, 반갑습니다.");
		mySmartPhone.hangUp();
		
		mySmartPhone.setWifi(true);
		mySmartPhone.internet();
	}

}
