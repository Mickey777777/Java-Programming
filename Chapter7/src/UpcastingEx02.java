
class Animal{
	String name;
	
	void nature() {
		System.out.println("Animal nature() called");
	}
}

class Fish extends Animal {
	String color;
	
	@Override
	void nature() {
		System.out.println("Fish nature() called");
	}
}

class Human extends Animal {
	
	@Override
	void nature() {
		System.out.println("Human nature() called");
	}
}

public class UpcastingEx02 {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.name = "BlueFish";
		
		Animal fish = new Fish();
		fish.name = "Whale";
		
		Animal person = new Human();
		person.name = "person1";
		
		Animal animals[] = {animal, fish, person};
		printObject(animals);
	}
	
	public static void printObject(Animal[] objs) {
		for(Animal a : objs) {
			System.out.print(a.name + " -> ");
			a.nature();
		}
	}

}
