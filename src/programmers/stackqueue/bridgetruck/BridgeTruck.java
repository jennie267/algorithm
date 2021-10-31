package programmers.stackqueue.bridgetruck;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 */
public class BridgeTruck {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 10, new int[] {7,4,5,6}));  // 8
        System.out.println(solution.solution(100, 100, new int[] {10}));    // 101
        System.out.println(solution.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110

    }

}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length; 
    }
}