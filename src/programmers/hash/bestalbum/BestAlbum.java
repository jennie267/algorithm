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
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution.solution(genres, plays);
        for (int i : result) {
            System.out.println(i);              // [4, 1, 3, 0]
        }


        /*속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        두 개씩 모아 베스트 앨범*/
    }

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length/2 * 2];
        
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
        
        
        int cnt = 0;
        for(Entry<String, Integer> entry : sortList) {
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
            while (playList.size() != stack.size() && cnt < answer.length) {
                if (genres[i].equals(genre) && plays[i] == playList.get(stack.size())) {
                    answer[cnt] = i;
                    cnt++;
                    stack.add(i);
                }
                i = (i+1)%plays.length;
            }
            
        }
        return answer;
    }
}