package programmers.kakao.internship.y2020.keypad;

/**
 * 키패드 누르기 level 1 2020 카카오 인턴십
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * 다시 정리한거
 */
public class Keypad2 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String result = solution.solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"); // LRLLLRLLRRL

		System.out.println("LRLLLRLLRRL".equals(result));

		String result1 = solution.solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"); // LRLLRRLLLRR
		System.out.println(result1);
		System.out.println("LRLLRRLLLRR".equals(result1));

		String result2 = solution.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"); // LLRLLRLLRL

		System.out.println("LLRLLRLLRL".equals(result2));

	}
}

class Solution2 {
	int[][] numberPad = { 
			{ 3, 1 }, // 0
			{ 0, 0 }, // 1
			{ 0, 1 }, // 2
			{ 0, 2 }, // 3
			{ 1, 0 }, // 4
			{ 1, 1 }, // 5
			{ 1, 2 }, // 6
			{ 2, 0 }, // 7
			{ 2, 1 }, // 8
			{ 2, 2 } // 9
	};

	int[] left = { 3, 0 };
	int[] right = { 3, 2 };

	public String solution(int[] numbers, String hand) {
		String answer = "";
		for (int num : numbers) {
			switch (num) {
			case 1:
			case 4:
			case 7:
				answer += "L";
				left = numberPad[num];
				break;
			case 3:
			case 6:
			case 9:
				answer += "R";
				right = numberPad[num];
				break;
			case 0:
			case 2:
			case 5:
			case 8:
				answer += findHand(num, hand);
				break;
			default:
				break;
			}
		}
		return answer;
	}

	public String findHand(int num, String hand) {
		int leftCnt = Math.abs(left[0] - numberPad[num][0]) + Math.abs(left[1] - numberPad[num][1]);
		int rightCnt = Math.abs(right[0] - numberPad[num][0]) + Math.abs(right[1] - numberPad[num][1]);

		if (leftCnt > rightCnt) {
			right = numberPad[num];
			return "R";
		} else if (leftCnt < rightCnt) {
			left = numberPad[num];
			return "L";
		} else {
			if (hand.equals("left")) {
				left = numberPad[num];
				return "L";
			} else {
				right = numberPad[num];
				return "R";
			}
		}
	}

}