package programmers.hash.cover;

import java.util.HashMap;
import java.util.Map;

/**
 * 위장
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Cover {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution.solution(clothes1));        // 5
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution.solution(clothes2));        // 3

    }
}

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }
        int answer = 1;
        for (Map.Entry<String, Integer> c : clothesMap.entrySet()) {
            answer = answer * (c.getValue()+1);
        }
        return answer-1;
    }
}