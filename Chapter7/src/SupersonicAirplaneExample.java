
public class SupersonicAirplaneExample {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		System.out.println();
		
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		System.out.println();
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
	}

}
