package programmers.heap.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class OperQueue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] operations = new String[]{"I 16","D 1"};
        int[] result = solution.solution(operations);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");      // 0 0
        }
        System.out.println();
        String[] operations2 = new String[]{"I 7","I 5","I -5","D -1"};
        int[] result2 = solution.solution(operations2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");      // 7 5
        }
        System.out.println();
        String[] operations3 = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result3 = solution.solution(operations3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");      // 0 0
        }
    }
}

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        for (String or : operations) {
            if (or.startsWith("I")) {
                int num = Integer.parseInt(or.substring(2));
                min.offer(num);
                max.offer(num);
            } else {
                if (min.isEmpty()) continue;

                int minNum = min.peek();
                int maxNum = max.peek();

                if (Integer.parseInt(or.substring(2)) > 0) {
                    min.remove(maxNum);
                    max.poll();
                } else {
                    min.poll();
                    max.remove(minNum);
                }
            }
        }

        if (min.isEmpty()) {
            return new int[]{0,0};
        }
        return new int[]{max.peek(),min.peek()};
    }
}