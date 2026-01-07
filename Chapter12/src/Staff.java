
public record Staff(String name, int age, String email) {
	@Override
	public String toString() {
		return String.format("[%s, %d, %s]", name, age, email);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Staff target) {
			if(this.name.equals(target.name) &&
					this.age == target.age) {
				return true;
			}
		}
		
		return false;
	}
}
