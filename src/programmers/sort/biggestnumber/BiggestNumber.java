package programmers.sort.biggestnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 큰 수
 * level 2
 * 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class BiggestNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers1 = new int[]{6, 10, 2};
        System.out.println(solution.solution(numbers1));   // 6210

        int[] numbers2 = new int[]{3, 30, 34, 5, 9};
        System.out.println(solution.solution(numbers2));   // 9534330
    }
}

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        Arrays.stream(numbers).forEach(num -> list.add(Integer.toString(num)));
        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));

        if ("0".equals(list.get(0))) {
            return "0";
        }

        for (String num : list) {
            answer.append(num);
        }
        return answer.toString();
    }
}