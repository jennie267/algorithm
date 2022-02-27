package programmers.weekly.amusementfee;

/**
 * 크레인 인형뽑기 게임
 * level 1
 * 위클리 챌린지
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 *
 */
public class AmusementFee {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(3, 20, 4);  // 10
        System.out.println(result); //10
        
    }

}

class Solution {
    public long solution(int price, int money, int count) {
        long need = 0;
        for (int i = 1; i <= count; i++) need += price * i;

        return need - money > 0 ? need-money : 0;
    }
}

class Solution_Ref {
    public long solution(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}