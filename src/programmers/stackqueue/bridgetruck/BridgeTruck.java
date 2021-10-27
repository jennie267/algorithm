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
    class Truck {
        int weight;
        int position;
        
        public Truck(int weight, int position) {
            super();
            this.weight = weight;
            this.position = position;
        }
        
        void crossBridge() {
            this.position--;
        }
        
        public boolean checkEscape() {
            if (this.position == 0) {
                return true;
            }
            return false;
        }
        
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0;
        Queue<Integer> trucks = new LinkedList<Integer>();
        for (int truck : truck_weights) {
            trucks.offer(truck);
        }
        Queue<Truck> bridge = new LinkedList<Truck>();
        
        long totalWeight = 0;
        while (!trucks.isEmpty() && !bridge.isEmpty()) {
            second++;
            Truck out = bridge.peek();
            
            int truck = trucks.peek();
            if (totalWeight + truck <= weight) {
                bridge.offer(new Truck(truck, bridge_length));
                trucks.poll();
            }
            
        }
        
        
        return second;
    }
}