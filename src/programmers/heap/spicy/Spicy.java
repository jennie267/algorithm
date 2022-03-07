package programmers.heap.spicy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 더 맵게
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Spicy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(solution.solution(scoville, k)); // 2

    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(i -> priorityQueue.offer(i));

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() <2) return -1;

            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            priorityQueue.offer(a + b * 2);
            answer++;
        }

        return answer;
    }
}