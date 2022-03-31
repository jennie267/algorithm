package programmers.practice.level2.num124;

/**
 * 124 나라의 숫자
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class Num124 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(1));   //1
        System.out.println(sol.solution(2));   //2
        System.out.println(sol.solution(3));   //4
        System.out.println(sol.solution(4));   //11
        System.out.println(sol.solution(5));   //12
    }

}
class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = new String[]{"4", "1", "2"};

        while (n > 0) {
            int a = n/3;
            int b = n%3;
            n = a;
            answer.insert(0, numbers[b]);
            if (b == 0) {
                n--;
            }
        }

        return answer.toString();
    }
}