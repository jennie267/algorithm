package programmers.heap.disk;

/**
 * 디스크 컨트롤러
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Disk {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution.solution(jobs));    // 9

        int[][] jobs2 = new int[][]{{0, 3}, {1, 9}, {2, 6}, {7, 1}};
        System.out.println(solution.solution(jobs2));    //

        int[][] jobs3 = new int[][]{{0, 3}, {1, 9}, {2, 6}, {20, 1}};
        System.out.println(solution.solution(jobs3));    //

    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        return answer;
    }
}