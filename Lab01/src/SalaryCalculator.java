// 2025005847 박우현
import java.util.Scanner;
public class SalaryCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("한달 동안 근무한 시간을 입력하세요: ");
			int time = scanner.nextInt();
			int overTime = 0;
			if(time == -1) break;
			int money = 0;
			if(time > 160) {
				overTime = time-160;
				money = 14790 * overTime + 9860*160;
			}else {
				money = 9860 * time;
			}
			
			System.out.printf("총 근무시간: %d시간, 초과 근무시간: %d시간, 월급: %,d원\n", time, overTime, money);
		}
		
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
