package programmers.dfsbfs.word;

/**
 * 단어 변환 level 3 (dfs)
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 
 * @author js.lee
 *
 */
public class WordDfs {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"})); // 4
		Solution solution2 = new Solution();
		System.out.println(solution2.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"})); // 0

	}

}

class Solution {
	int answer;
	boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		answer = words.length;
		visited = new boolean[words.length];

		if (!checkInclude(target, words)) {
			return 0;
		}

		dfs(begin, target, words, 0);

		return answer;
	}

	boolean checkInclude(String target, String[] words) {
		for (String word : words) {
			if (target.equals(word)) {
				return true;
			}
		}
		return false;
	}

	boolean checkChangeable(String begin, String target) {
		int count = 0;

		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == target.charAt(i)) {
				count++;
			}
		}
		return count == begin.length() - 1 ? true : false;
	}

	void dfs(String begin, String target, String[] words, int count) {
		if (begin.equals(target)) {
			if (answer > count) {
				answer = count;
			}
		}
		
		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && checkChangeable(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, count + 1);
				visited[i] = false;
			}
		}
	}

}
