package programmers.stackqueue.printer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프린터
 * level 2
 * https://programmers.co.kr/learn/courses/30/parts/12081
 *
 */
public class Printer {

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        System.out.println(solution1.solution(new int[] {2, 1, 3, 2}, 2));     // 1
        Solution solution2 = new Solution();
        System.out.println(solution2.solution(new int[] {1, 1, 9, 1, 1, 1}, 0));     // 5
        

    }

}

class Solution {
    int[] priority = new int[10];
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> printer = new LinkedList<Integer>();
        for (int i = 0; i < priorities.length; i++) {
            this.priority[priorities[i]]++;
            printer.offer(priorities[i]);
        }
        while (location >= 0 && !printer.isEmpty()) {
            int target = printer.poll();
            if (location == 0) {
                if (checkMax(target)) {
                    printer.offer(target);
                    location = printer.size();
                } else {
                    answer++;
                    return answer;
                }
            } else {
                if (checkMax(target)) {
                    printer.offer(target);
                }  else {
                    priority[target]--;
                    answer++;
                }
            }
            
            location--;
            
        }
        return answer;
    }
    
    private boolean checkMax(int target) {
        for (int i = target+1; i < priority.length; i++) {
            if (priority[i] > 0) {
                return true;
            }
        }
        return false;
    }
}