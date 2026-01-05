
class Shape{
	public Shape() {}
	public void draw() {
		System.out.println("Shape draw");
	}
}

class Line extends Shape{
	public void draw() {
		System.out.println("Line draw");
	}
}

class Rect extends Shape{
	public void draw() {
		System.out.println("Rect draw");
	}
}

class Circle extends Shape{
	public void draw() {
		System.out.println("Circle draw");
	}
}


public class MethodOverridingEx {
	
	public static void main(String[] args) {
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}
	
	static void paint(Shape p) {
		if(p instanceof Shape) 
			System.out.print("Shape object-");
		if(p instanceof Line) 
			System.out.print("Line object-");
		if(p instanceof Rect) 
			System.out.print("Rect object-");
		if(p instanceof Circle) 
			System.out.print("Cirlce object-");
		
		
		p.draw();
	}

}
