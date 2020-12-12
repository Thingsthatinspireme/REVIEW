package home.self._1212;

import java.util.Random;
import java.util.Scanner;

class Rpc {

	String user() {
		
		
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		
		
		switch (user) {

			case "가위":
				return "가위";
			case "바위":
				return "바위";
			case "보":
				return "보";
		}

		return "잘못 입력하셨습니다. 다시 시작하세요";

	}

	String computer() {

		Random rd = new Random();
		int com = rd.nextInt(3);

		if (com == 0)
			return "가위";
		else if (com == 1)
			return "바위";
		else
			return "보";
	}

	void outCome(String user, String com) {
		System.out.printf("사용자 : " + user + ", 컴퓨터 : " + com);
		System.out.println();
		System.out.println();
		if (user == com) {
			System.out.println("=>무승부");
		} else if (user == "가위" && com == "바위") {
			System.out.println("=>컴퓨터 승리");
		} else if (user == "가위" && com == "보") {
			System.out.println("=>사용자 승리");
		} else if (user == "바위" && com == "가위") {
			System.out.println("=>사용자 승리");
		} else if (user == "바위" && com == "보") {
			System.out.println("=>컴퓨터 승리");
		} else if (user == "보" && com == "가위") {
			System.out.println("=>컴퓨터 승리");
		} else if (user == "보" && com == "바위") {
			System.out.println("=>사용자 승리");
		}
		System.out.println("-----------------------");
	}
}

public class Ex02 {

	public static void main(String[] args) {

		// 가위 바위 보 게임.컴퓨터는 난수로 생성하고 사용자는 문자열로 입력
		// 10번 진행하고 승 패 비김 을 출력

		System.out.println("가위 바위 보를 시작합니다.");
		System.out.println("-----------------------");

		Rpc rpc = new Rpc();

		int round = 1;
		while (round <= 10) {

			System.out.println("round : " + round++);
			System.out.println("-----------------------");
			System.out.println("가위, 바위, 보 중에서 입력해주세요");
			rpc.outCome(rpc.user(), rpc.computer());

		}

	}

}