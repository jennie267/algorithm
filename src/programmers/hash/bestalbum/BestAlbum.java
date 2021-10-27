package programmers.hash.bestalbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * 베스트앨범
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 */
public class BestAlbum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
        for (int i : result) {
            System.out.println(i);              // [4, 1, 3, 0]
        }
        System.out.println("=====================");
        int[] result2 = solution.solution(new String[] {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"}, new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        for (int i : result2) {
            System.out.println(i);              // [0, 1, 2, 4]
        }
        
    }

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<Integer>();
        
        Map<String, Integer> albumMap = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
            albumMap.put(genres[i], albumMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> sortList = new ArrayList<Map.Entry<String,Integer>>(albumMap.entrySet());
        
        Collections.sort(sortList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        
        for(Entry<String, Integer> entry : sortList) {
            int cnt = 0;
            String genre = entry.getKey();
            List<Integer> playList = new ArrayList<Integer>();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    playList.add(plays[i]);
                }
            }
            Collections.sort(playList, Collections.reverseOrder());
            int i = 0;
            Stack<Integer> stack = new Stack<Integer>();
            while (playList.size() != stack.size() && cnt < 2) {
                if (genres[i].equals(genre) && plays[i] == playList.get(stack.size())) {
                    answer.add(i);
                    cnt++;
                    stack.add(i);
                }
                i = (i+1)%plays.length;
            }
            
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}