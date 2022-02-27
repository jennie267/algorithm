package programmers.etc.basic;

/**
 * 문자열 다루기 기본
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class Basic {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("a234")); //false
        System.out.println(solution.solution("1234")); //true
        System.out.println(solution.solution("123")); //false
        System.out.println(solution.solution("123456")); //true
        
    }

}

class Solution {
    public boolean solution(String s) {
    	if (s.length() != 4 && s.length() != 6) return false;
        return s.matches("[0-9]+");
    }
}