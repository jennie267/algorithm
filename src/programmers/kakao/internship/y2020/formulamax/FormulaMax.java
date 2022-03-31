package programmers.kakao.internship.y2020.formulamax;

/**
 * 수식 최대화
 * 2020 카카오 인턴십
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */
public class FormulaMax {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("100-200*300-500+20"));   // 60420
        System.out.println(sol.solution("50*6-3*2"));   // 300
    }

}

class Solution {
    public long solution(String expression) {
        String[] numbers = expression.replaceAll("([-*])", "+").split("\\+");
        String[] exps = expression.replaceAll("[0-9]","").split("");

        // + - *
        long answer = Math.abs(cal(new String[]{"+","-","*"}, numbers.clone(), exps.clone()));

        // + * -
        answer = Math.max(answer, Math.abs(cal(new String[]{"+","*","-"}, numbers.clone(), exps.clone())));

        // - + *
        answer = Math.max(answer, Math.abs(cal(new String[]{"-","+","*"}, numbers.clone(), exps.clone())));

        // - * +
        answer = Math.max(answer, Math.abs(cal(new String[]{"-","*","+"}, numbers.clone(), exps.clone())));

        // * + -
        answer = Math.max(answer, Math.abs(cal(new String[]{"*","+","-"}, numbers.clone(), exps.clone())));

        // * - +
        answer = Math.max(answer, Math.abs(cal(new String[]{"*","-","+"}, numbers.clone(), exps.clone())));

        return answer;
    }

    public long cal(String[] order, String[] numbers, String[] exps) {
        for (String exp : order) {
            for (int j = 0; j < exps.length; j++) {
                if (exp.equals(exps[j])) {
                    String a = "x";
                    String b = "x";
                    int ai = 0;
                    while (a.equals("x")) {
                        a = numbers[j - ai];
                        ai++;
                    }
                    long anum = Long.parseLong(a);
                    int bi = 1;
                    while (b.equals("x")) {
                        b = numbers[j + bi];
                        bi++;
                    }
                    long bnum = Long.parseLong(b);
                    long num = 0;
                    switch (exp) {
                        case "+":
                            num = anum + bnum;
                            break;
                        case "-":
                            num = anum - bnum;
                            break;
                        case "*":
                            num = anum * bnum;
                            break;
                    }
                    exps[j] = "x";
                    numbers[j - ai + 1] = String.valueOf(num);
                    numbers[j + bi - 1] = "x";

                }
            }
        }
        for (String number : numbers) {
            if (!number.equals("x")) {
                return Long.parseLong(number);
            }
        }
        return -1;
    }
}