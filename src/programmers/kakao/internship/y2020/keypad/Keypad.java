package programmers.kakao.internship.y2020.keypad;

/**
 * 키패드 누르기
 * level 1
 * 2020 카카오 인턴십
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Keypad {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String result = solution.solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"); // LRLLLRLLRRL

		System.out.println("LRLLLRLLRRL".equals(result));

		String result1 = solution.solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"); // LRLLRRLLLRR
		System.out.println(result1);
		System.out.println("LRLLRRLLLRR".equals(result1));

		String result2 = solution.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"); // LLRLLRLLRL

		System.out.println("LLRLLRLLRL".equals(result2));

	}
}

class Solution {
	int[] left = { 0, 0 };
	int[] right = { 0, 0 };

	public String solution(int[] numbers, String hand) {
		left[0] = 3;
		left[1] = 0;
		right[0] = 3;
		right[1] = 2;
		StringBuilder answer = new StringBuilder();
		for (int num : numbers) {
			switch (num) {
			case 0:
				answer.append(findCursor(3, 1, hand));
				break;
			case 1:
				answer.append(locateCursor(0, 0, "left"));
				break;
			case 2:
				answer.append(findCursor(0, 1, hand));
				break;
			case 3:
				answer.append(locateCursor(0, 2, "right"));
				break;
			case 4:
				answer.append(locateCursor(1, 0, "left"));
				break;
			case 5:
				answer.append(findCursor(1, 1, hand));
				break;
			case 6:
				answer.append(locateCursor(1, 2, "right"));
				break;
			case 7:
				answer.append(locateCursor(2, 0, "left"));
				break;
			case 8:
				answer.append(findCursor(2, 1, hand));
				break;
			case 9:
				answer.append(locateCursor(2, 2, "right"));
				break;

			default:
				break;
			}
		}
		return answer.toString();
	}

	public String locateCursor(int x, int y, String hand) {
		if (hand.equals("left")) {
			left[0] = x;
			left[1] = y;
			return "L";
		} else {
			right[0] = x;
			right[1] = y;
			return "R";
		}
	}

	public String findCursor(int x, int y, String hand) {
		int leftCnt = Math.abs(left[0] - x) + Math.abs(left[1] - y);
		int rightCnt = Math.abs(right[0] - x) + Math.abs(right[1] - y);

		if (leftCnt > rightCnt) {
			right[0] = x;
			right[1] = y;
			return "R";
		} else if (leftCnt < rightCnt) {
			left[0] = x;
			left[1] = y;
			return "L";
		} else {
			if (hand.equals("left")) {
				left[0] = x;
				left[1] = y;
				return "L";
			} else {
				right[0] = x;
				right[1] = y;
				return "R";
			}
		}
	}

}