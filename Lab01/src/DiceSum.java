// 2025005847 박우현
public class DiceSum {

	public static void main(String[] args) {
		while(true) {
			int dice1 = (int)(Math.random()*6)+1;
			int dice2 = (int)(Math.random()*6)+1;
			int sum = dice1+dice2;
			if(sum == 5) {
				System.out.printf("주사위(%d, %d) = %d -> 주사위의 합은 5입니다.\n", dice1, dice2, sum);
				break;
			}
			else System.out.printf("주사위(%d, %d) = %d -> 다시 주사위를 던집니다.\n", dice1, dice2, sum);
		}
		System.out.println("프로그램 종료");

	}

}
