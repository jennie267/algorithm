package programmers.hash.participant;

/**
 * 완주하지 못한 선수
 *  level 1
 *  https://programmers.co.kr/learn/courses/30/lessons/42576
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
        for (int i = 0; i < participant.length; i++) {
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    participant[i] = "";
                    completion[j] = "";
                    break;
                }
            }
            if (!"".equals(participant[i])) {
                return participant[i];
            }
        }
        return "";
    }
}
