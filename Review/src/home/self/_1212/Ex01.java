package home.self._1212;

import java.util.Scanner;

class Point {

	static int x1 = 50;
	static int y1 = 50;
	static int x2 = 100;
	static int y2 = 100;

	static Scanner sc = new Scanner(System.in);

	int newX3() {
		System.out.println("x축 첫번째 좌표 입력");
		int x3 = sc.nextInt();
		return x3;
	}

	int newY3() {
		System.out.println("y축 첫번째 좌표 입력");
		int y3 = sc.nextInt();
		return y3;
	}

	int newX4() {
		System.out.println("x축 두번째 좌표 입력");
		int x4 = sc.nextInt();
		return x4;
	}

	int newY4() {
		System.out.println("y축 두번째 좌표 입력");
		int y4 = sc.nextInt();
		return y4;
	}

	boolean crush(int x3, int y3, int x4, int y4) {

		System.out.println("x3, y3 : (" + x3 + "," + y3 + ")");
		System.out.println("x4, y4 : (" + x4 + "," + y4 + ")");
		if (((x1 < x3 && x3 < x2) && (y1 < y3 && y3 < y2))
				|| ((x1 < x4 && x4 < x2) && (y1 < y4 && y4 < y2))) {
			System.out.println("직사각형들이 충돌을 일으킵니다. 좌표를 다시 입력해주세요");
			System.out.println("-------------------------------------");
			return false;
		} else {
			System.out.println("직사각형들이 충돌을 일으키지 않습니다");
			return true;
		}

	}
}

public class Ex01 {

	public static void main(String[] args) {
		// 2차원 평면에서 하나의 직사각형은 두 점으로 표현된다. (50, 50)과 (100, 100)의
		// 두 점으로 이루어진 직사각형이 있다고 하자.
		// 이때 키보드로부터 다른 직사각형을 구성하는 두 점(x1, y1), (x2, y2)를 입력받아
		// 두 개의 직사각형이 서로 충돌하는지 판별하는 프로그램을 작성하세요

		System.out.println("새로운 직사각형의 좌표를 입력해주세요.");

		Point point = new Point();

		boolean boo = false;
		while (boo == false) {

			boo = point.crush(point.newX3(), point.newY3(), point.newX4(),
					point.newY4());

		}
	}

}
