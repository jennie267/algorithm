package programmers.kakao.internship.winter2019.crane;

import java.util.Stack;

/**
 * 2019 카카오 개발자 겨울 인턴십
 * 크레인 인형뽑기 게임
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 *
 */
public class Crane {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});   // 4

        System.out.println(result); // 4
        
    }

}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int m : moves)
            for (int j = 0; j < board.length; j++) {
                int boardNum = board[j][m - 1];
                if (boardNum == 0) continue;

                if (stack.empty()) {
                    stack.push(boardNum);
                } else {
                    if (stack.peek() == boardNum) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(boardNum);
                    }
                }
                board[j][m - 1] = 0;
                break;
            }
        return answer;
    }
}