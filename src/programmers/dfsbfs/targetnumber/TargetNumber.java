package programmers.dfsbfs.targetnumber;

/**
 * 타겟 넘버 level 2
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 * 
 * @author js.lee
 *
 */
public class TargetNumber {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = { 1, 1, 1, 1, 1 };
		System.out.println(solution.solution(numbers, 3)); // 5

	}

}

class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, target, 0, 0);
		return answer;
	}

	public int dfs(int[] numbers, int target, int sum, int index) {
		if (index == numbers.length) {
			if (target == sum) {
				return 1;
			}
			return 0;
		}
		
		return dfs(numbers, target, sum + numbers[index], index+1) + dfs(numbers, target, sum - numbers[index], index+1);
	}
	
}
