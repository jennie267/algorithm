package programmers.dynamicprogramming.express;

import java.util.*;

/**
 * N으로 표현
 * level 3
 * 동적계획법(Dynamic Programming)
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */
public class NExpress {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 5800));  // 8
        System.out.println(sol.solution(2, 44));    // 3
        System.out.println(sol.solution(2, 34));    // 6
        System.out.println(sol.solution(5, 31168)); // -1
        System.out.println(sol.solution(3, 77));    // 7
        System.out.println(sol.solution(2, 33));    // 5
        System.out.println(sol.solution(5, 12));    // 4
        System.out.println(sol.solution(2, 11));    // 3
        System.out.println(sol.solution(2, 22));    // 2

    }
}

class Solution {
    public int solution(int N, int number) {
        if (number == N) {
            return 1;
        }
        String nStr = "" + N;
        int len = (int)(Math.log10(number)+1);
        int[] nArr = new int[9];
        nArr[0] = N;
        for (int i = 1; i < 9; i++) {
            nArr[i] = Integer.parseInt(nStr + nArr[i-1]);
        }

        if (nArr[len-1] == number) {
            return len;
        }

        List<Set<Integer>> depth = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        first.add(nArr[0]);
        depth.add(first);
        int i = 1;
        while (i <= 7) {
            Set<Integer> newSet = new HashSet<>();
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = depth.get(j-1);
                Set<Integer> preSet2 = depth.get(i-j);
                for (Integer num1 : preSet) {
                    for (Integer num2 : preSet2) {
                        int a = num1+num2;
                        int b = num1-num2;
                        int c = num1*num2;
                        int d = num1/num2;
                        int e = nArr[i];
                        if (a == number || b == number || c == number || d == number || e == number) {
                            return i+1;
                        }
                        newSet.add(a);
                        newSet.add(b);
                        newSet.add(c);
                        newSet.add(d);
                        newSet.add(e);
                        newSet.remove(0);
                    }
                }
            }
            depth.add(newSet);
            i++;
        }
        return -1;
    }
}