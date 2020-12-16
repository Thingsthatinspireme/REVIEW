package home.self._1216;

package ex03.homework._1215;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class GeneratorThreeNum {
	public int[] randomNum() {
		int[] com = new int[3];
		while (com[0] == com[1] && com[0] == com[2] && com[1] == com[2]) {
			Random rd = new Random();

			com[0] = rd.nextInt(10);
			com[1] = rd.nextInt(10);
			com[2] = rd.nextInt(10);

		}
		System.out.println(Arrays.toString(com));
		return com;
	}
}// 난수 3개를 생성하는 역할

class BaseBallMenu {
	static Scanner sc = new Scanner(System.in);
	static int[] input = new int[3];

	public static int[] user() {
		System.out.println("첫번째 숫자 입력 >> ");
		input[0] = sc.nextInt();
		System.out.println("두번째 숫자 입력 >> ");
		input[1] = sc.nextInt();
		System.out.println("세번째 숫자 입력 >> ");
		input[2] = sc.nextInt();
		return input;
	}

	public static void showMenu() {

		System.out.println("=====Strike Game=====");
		System.out.println("규칙 : 컴퓨터가 중복값이 없는 3자리 숫자를 고릅니다.");
		System.out.println("     user는 숫자를 맞춰야 합니다");

	}

	public static boolean endMenu() {

		System.out.println("다시 하시겠습니까? Y/N");
		String yn = sc.next();
		System.out.println(yn);
		switch (yn) {
		case "Y":
			return true;
		case "N":
			return false;
		}

		return true;
	}

}// 메뉴를 담당하는 역할

class DecisionBall {
	int strike = 0;
	int ball = 0;

	public void strikeBall(int com[], int user[]) {

		while (true) {

			for (int i = 0; i < user.length; i++) {
				
				if (user[0] == com[0] && user[1] == com[1] && user[2] == com[2]) {
					
					System.out.println("Three Strike!!!");
					return;
				} else if (user[i] == com[i]) {
					strike++;

				} else if (user[i] == com[0] || user[i] == com[1]
						|| user[i] == com[2]) {
					ball++;

				}
				
				if (strike == 3) {
					System.out.println("삼진아웃!");
					return;
				}
				
			}
			System.out.println(strike + "Strike! "+ ball + "Ball!");
			BaseBallMenu.user();
			strike = 0;
			ball = 0;
		}

	}// 스트라이크, 볼을 판단하는 역할
}

public class BaseBall {
	public static void main(String[] args) {

		GeneratorThreeNum threeNum = new GeneratorThreeNum();
		DecisionBall db = new DecisionBall();
		boolean boo = true;
		while (boo) {
			BaseBallMenu.showMenu();
			db.strikeBall(threeNum.randomNum(), BaseBallMenu.user());
			boo = BaseBallMenu.endMenu();

		}

	}
}