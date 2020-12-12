package home.self._1212;

import java.util.Random;
import java.util.Scanner;

class Guess {
	int com() {
		Random rd = new Random();
		int com = rd.nextInt(101); // 0~100사이의 숫자
		return com;
	}

	int user() {
		System.out.println("--------------");
		System.out.println("숫자를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		return user;
	}

	boolean outCome(int user, int com, int i) {
		System.out.println("사용자 : " + user + ", 컴퓨터 :" + com);

		if (user > com) {
			System.out.println("큽니다");
			return true;
		} else if (user < com) {
			System.out.println("작습니다");
			return true;
		} else {
			System.out.println(i + "회 만에 맞췄습니다");
			return false;
		}

	}
}

public class Ex03 {

	public static void main(String[] args) {
		// 6. 컴퓨터로 0~100사이의 임의의 난수를 생성합니다
		// 사용자로부터 0~100사이의 숫자를 입력받습니다
		// 컴퓨터가 생성한 난수보다 크면 "큽니다"
		// 작으면 "작습니다"를 출력합니다
		// 계속 반복하다가 맞추면 "?회만에 맞췄습니다"
		// 를 출력하세요.

		System.out.println("숫자 맞추기");

		Guess guess = new Guess();
		int com = guess.com();
		int round = 1;
		boolean boo = true;
		while (boo == true) {

			boo = guess.outCome(guess.user(), com, round);
			round++;
		}

	}

}