package programmers.exhaustivesearch.mocktest;

import java.util.Arrays;

/**
 * 모의고사
 * level 1
 * 완전탐색
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MockTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answers = new int[]{1, 2, 3, 4, 5};
        int[] result = s.solution(answers);
        for (int i : result) {
            System.out.println(i);  // 1
        }

        int[] answers2 = new int[]{1, 3, 2, 4, 2};
        int[] result2 = s.solution(answers2);
        for (int i : result2) {
            System.out.println(i);  // 1, 2, 3
        }

    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;

        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i%aLen]) aCnt++;
            if (answers[i] == b[i%bLen]) bCnt++;
            if (answers[i] == c[i%cLen]) cCnt++;
        }
        int max = 0;
        if (aCnt > max) max = aCnt;
        if (bCnt > max) max = bCnt;
        if (cCnt > max) max = cCnt;

        StringBuffer sb = new StringBuffer();
        if (aCnt == max) sb.append("1,");
        if (bCnt == max) sb.append("2,");
        if (cCnt == max) sb.append("3");

        return Arrays.stream(sb.toString().split(","))
                .filter(i -> !i.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}