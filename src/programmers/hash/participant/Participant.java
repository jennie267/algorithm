package programmers.hash.participant;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Participant {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));   // leo
        System.out.println(solution.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));   // vinko
        System.out.println(solution.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));   // mislav
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> ptMap = new HashMap<>();
        for (String s : participant) {
            ptMap.put(s, ptMap.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            ptMap.put(s, ptMap.get(s) - 1);
        }

        for (String key : ptMap.keySet()) {
            if (ptMap.get(key) != 0) {
                return key;
            }
        }
        return "";
    }

}
