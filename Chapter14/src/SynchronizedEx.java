class SharedBoard {
	private int sum = 0;
	synchronized public void add() {
		sum += 10;
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}

//	public void add() {
//		sum += 10;
//		System.out.println(Thread.currentThread().getName() + " : " + sum);
//	}
	
	public int getSum() {
		return sum;
	}
}

class StudentThread extends Thread {
	private SharedBoard board;
	
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			board.add();
		}
	}
}

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread s1 = new StudentThread("student1", board);
		Thread s2 = new StudentThread("student2", board);
		
		s1.start();
		s2.start();

	}

}
