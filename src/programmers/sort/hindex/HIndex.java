package programmers.sort.hindex;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * H-Index
 * level 2
 * 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution.solution(citations));   // 3

        int[] citations2 = new int[]{3, 4, 5, 11, 15, 16, 17, 18, 19, 20};
        System.out.println(solution.solution(citations2));   // 7

        int[] citations3 = new int[]{0, 0, 0, 0, 0};
        System.out.println(solution.solution(citations3));   // 0

        int[] citations4 = new int[]{1, 4};
        System.out.println(solution.solution(citations4));   // 1

        int[] citations5 = new int[]{0, 1, 2};
        System.out.println(solution.solution(citations5));   // 1
    }
}

class Solution {
    public int solution(int[] citations) {
        Integer[] cis = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(cis, Collections.reverseOrder());

        int i = 0;
        int h = 0;
        while (i <= citations.length) {
            i++;
            if (i < cis[i]) return h;
            h = cis[i];
        }
        return 0;
    }
}