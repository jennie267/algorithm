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
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution.solution(participant1, completion1));   // leo

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant2, completion2));   // vinko

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(solution.solution(participant3, completion3));   // mislav
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
