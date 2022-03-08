package programmers.heap.disk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
        System.out.println(solution.solution(jobs2));    // 7

        int[][] jobs3 = new int[][]{{0, 3}, {1, 9}, {2, 6}, {20, 1}};
        System.out.println(solution.solution(jobs3));    // 7

    }
}

class Solution {
    public int solution(int[][] jobs) {
        int size = jobs.length;
        int totTime = 0;

        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int i = 0;
        int curTime = 0;
        while (size > 0) {
            while (i < jobs.length && jobs[i][0] <= curTime) {
                queue.offer(jobs[i++]);
            }

            if (queue.isEmpty()) {
                curTime = jobs[i][0];
            } else {
                int[] request = queue.poll();
                totTime += curTime - request[0] + request[1];
                curTime += request[1];
                size--;
            }

        }
        return (int) Math.floor(totTime/jobs.length);
    }
}