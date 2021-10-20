package programmers.dfsbfs.word;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환 level 3 (bfs)
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 
 * @author js.lee
 *
 */
public class WordBfs {

	public static void main(String[] args) {
		SolutionBfs solution = new SolutionBfs();
		String begin = "hit";
		String target = "cog";
		String[] words1 = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words2 = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(solution.solution(begin, target, words1)); // 4
		SolutionBfs solution2 = new SolutionBfs();
		System.out.println(solution2.solution(begin, target, words2)); // 0

	}

}

class SolutionBfs {

	static class Node {
		String current;
		int edge;

		public Node(String next, int edge) {
			this.current = next;
			this.edge = edge;
		}
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		if (!checkInclude(target, words)) {
			return answer;
		}

		Queue<Node> queue = new LinkedList<>();

		boolean[] visited = new boolean[words.length];
		queue.add(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.current.equals(target)) {
				answer = node.edge;
				break;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && checkChangeable(node.current, words[i])) {
					visited[i] = true;
					queue.add(new Node(words[i], node.edge + 1));
				}
			}
		}

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

}
