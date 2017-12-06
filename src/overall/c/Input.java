package overall.c;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	public static int nextInt(int minRange,int maxRange) {
		Scanner s = new Scanner(System.in);
		while(true) {
			try {
				int num = s.nextInt();
				if(num >= minRange && num <= maxRange) {
					s.close();
					return num;
				}
				System.out.println(minRange + "から" + maxRange + "の間の整数を入力してください");
			}catch(InputMismatchException e) {
				System.out.println("正しい整数を入力してください");
				s.nextLine();
			}
		}
	}
}
