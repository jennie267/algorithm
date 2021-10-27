package programmers.dfsbfs.network;

/**
 * 네트워크 level 3
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * 
 * @author js.lee
 *
 */
public class Network {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } })); // 2
		System.out.println(solution.solution(3, new int[][] {{ 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 }})); // 1

	}

}

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(computers, i, visited);
				answer++;
			}
		}
		return answer;
	}
	
	void dfs(int[][] computers, int start, boolean[] visited) {
		visited[start] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if (start != j && computers[start][j] == 1 && visited[j] == false) {
				dfs(computers, j, visited);
			}
		}
	}
}
