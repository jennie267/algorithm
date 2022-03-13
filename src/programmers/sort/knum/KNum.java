package programmers.sort.knum;

import java.util.Arrays;

/**
 * K번째수
 * level 1
 * 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = solution.solution(array, commands);
        Arrays.stream(result).forEach(System.out::println);  // 5, 6, 3
    }
    
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int cursor = 0;
        for (int[] command : commands) {
            int i = command[0]-1;
            int j = command[1];
            int k = command[2]-1;

            int[] newArray = Arrays.stream(array, i, j).sorted().toArray();
            answer[cursor++] = newArray[k];
        }

        return answer;
    }
}