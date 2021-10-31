package programmers.stackqueue.stockprice;

/**
 * 주식가격
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{1, 2, 3, 2, 3});

        // [4, 3, 1, 1, 0]
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}