
public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode(): " +
								name.hashCode() + age);
		return name.hashCode() +age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member target) {
			return target.name == this.name && target.age == this.age;
		}
		return false;
	}
}
