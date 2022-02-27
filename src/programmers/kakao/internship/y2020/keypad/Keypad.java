package programmers.kakao.internship.y2020.keypad;

/**
 * 키패드 누르기
 * level 1
 * 2020 카카오 인턴십
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * 기존에 푼거
 */
public class Keypad {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String result = solution.solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"); // LRLLLRLLRRL
		System.out.println("LRLLLRLLRRL".equals(result));
		
		String result1 = solution.solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"); // LRLLRRLLLRR
		System.out.println("LRLLRRLLLRR".equals(result1));
		
		String result2 = solution.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"); // LLRLLRLLRL
		System.out.println("LLRLLRLLRL".equals(result2));

	}
}

class Solution {
    static int[][] position = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] left = {3,0};
        int[] right = {3,2};
        
        for(int num : numbers) {
        	if(num == 1 || num == 4 || num == 7) {
        		answer += "L";
        		left = position[num];
        	} else if (num == 3 || num == 6 || num == 9) {
        		answer += "R";
        		right = position[num];
        	} else {
        		int leftMove = Math.abs(left[0]-position[num][0]) + Math.abs(left[1]-position[num][1]);
        		int rightMove = Math.abs(right[0]-position[num][0]) + Math.abs(right[1]-position[num][1]);
        		if (leftMove == rightMove) {
					if ("left".equals(hand)) {
						answer += "L";
		        		left = position[num];
					}else {
						answer += "R";
		        		right = position[num];
					}
				} else if (leftMove > rightMove) {
					answer += "R";
	        		right = position[num];
					
				} else {
					answer += "L";
	        		left = position[num];
				}
        		
        	}
        	
		}
        return answer.toString();
    
    }
}