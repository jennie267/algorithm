package programmers.kakao.internship.y2021;

/**
 * 숫자 문자열과 영단어
 * 2021 카카오 채용연계형 인턴십
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class NumberStrEngWord {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("one4seveneight"));   // 1478
        System.out.println(s.solution("23four5six7"));      // 234567
        System.out.println(s.solution("2three45sixseven")); // 234567
        System.out.println(s.solution("123"));              // 123

    }

    static class Solution {
        public int solution(String s) {
            if (isNumber(s)) {
                return Integer.parseInt(s);
            }

            return Integer.parseInt(replaceStr(s));
        }

        public boolean isNumber(String s) {
            return s.matches("-?\\d+(\\.\\d+)?");
        }

        public String replaceStr(String s) {
            return s.replaceAll("zero", "0")
            .replaceAll("one", "1")
            .replaceAll("two", "2")
            .replaceAll("three", "3")
            .replaceAll("four", "4")
            .replaceAll("five", "5")
            .replaceAll("six", "6")
            .replaceAll("seven", "7")
            .replaceAll("eight", "8")
            .replaceAll("nine", "9");
        }
    }
}
