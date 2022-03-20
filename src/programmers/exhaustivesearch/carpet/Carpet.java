package programmers.exhaustivesearch.carpet;

/**
 * 카펫
 * level 2
 * 완전 탐색
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result1 = s.solution(10, 2);  // 4,3
        int[] result2 = s.solution(8, 1);   // 3,3
        int[] result3 = s.solution(24, 24); // 8,6
        int[] result4 = s.solution(12, 4); // 4,4

        Solution_Ref ref = new Solution_Ref();
        int[] result5 = ref.solution(10, 2);  // 4,3
        int[] result6 = ref.solution(8, 1);   // 3,3
        int[] result7 = ref.solution(24, 24); // 8,6
        int[] result8 = ref.solution(12, 4); // 4,4

    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 3;
        int y = 3;
        int tot = brown + yellow;
        for (int i = x; i < tot/y+1; i++) {
            for (int j = y; j < tot/x+1; j++) {
                if (i*j == tot && (i-2) * (j-2) == yellow) {
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{};
    }
}

class Solution_Ref {
    public int[] solution(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = brown + yellow;
        return new int[]{(int) (a + Math.sqrt(a * a - 4 * b)) / 2, (int) (a - Math.sqrt(a * a - 4 * b)) / 2};
    }
}