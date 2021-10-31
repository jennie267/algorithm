package programmers.stackqueue.bridgetruck;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck_Ref {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(2, 10, new int[] {7,4,5,6}));  // 8
        System.out.println(solution.solution(100, 100, new int[] {10}));    // 101
        System.out.println(solution.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110

    }
}

class Solution2 {
    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
