package programmers.dfsbfs.travel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 여행경로 level 3
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 * 
 * @author js.lee
 *
 */
public class Travel {

	public static void main(String[] args) {
		Solution solution1 = new Solution();
		String[][] tickets1 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		//String[] test1 = solution1.solution(tickets1); // ["ICN", "JFK", "HND", "IAD"]
		/*		for (String string : test1) {
					System.out.println(string);
				}*/
		System.out.println();
		Solution solution2 = new Solution();
		String[][] tickets2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		//String[] test2 = solution1.solution(tickets2); // ["ICN","ATL", "ICN", "SFO", "ATL", "SFO"]
		/*		for (String string : test2) {
					System.out.println(string);
				}*/
		System.out.println();
		Solution solution3 = new Solution();
		String[][] tickets3 = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
		String[] test3 = solution1.solution(tickets3); // ["ICN","ATL", "ICN", "SFO", "ATL", "SFO"]
		for (String string : test3) {
			System.out.println(string);
		}


	}

}

class Solution {
	public String[] solution(String[][] tickets) {
		boolean[] visited = new boolean[tickets.length];

		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});
		int i = 0;
		for (; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				break;
			}
		}

		List<String> test = new ArrayList<String>();
		for (; i < tickets.length; i++) {
			List<String> answerList = new ArrayList<String>();
			String from = tickets[i][0];
			String to = tickets[i][1];
			answerList.add(from);
			answerList.add(to);
			visited[i] = true;
			dfs(to, tickets, i, answerList, visited);
			if (test.size() <= answerList.size()) {
				test.addAll(answerList);
			}
		}

		String[] answer = new String[test.size()];
		for (int j = 0; j < answer.length; j++) {
			answer[j] = test.get(j);
		}

		return answer;
	}

	void dfs(String to, String[][] tickets, int index, List<String> answer, boolean[] visited) {
		if (index == tickets.length) {
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(to)) {
				answer.add(tickets[i][1]);
				visited[i] = true;
				dfs(tickets[i][1], tickets, i, answer, visited);
			}
		}

	}
}
