package programmers.stackqueue.develop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 기능개발
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 */
public class Develope {

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = solution1.solution(progresses1, speeds1);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }   // 2,1
        System.out.println("=======");
        Solution solution2 = new Solution();
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = solution2.solution(progresses2, speeds2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }   // 1,3,2
        

    }

}

class Solution {
    class Job {
        int progress;
        int speed;
        
        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public int countDays() {
            return (100-this.progress)/this.speed + ((100-this.progress)%this.speed>0?1:0);
        }

    }
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();
        Queue<Job> job = new LinkedList<Solution.Job>();
        for (int i = 0; i < progresses.length; i++) {
            job.offer(new Job(progresses[i], speeds[i]));
        }
        int count = 0;
        int days = 0;
        while (!job.isEmpty()) {
            int jobDay = job.poll().countDays();
            if (days == 0) {
                count++;
                days = jobDay;
                continue;
            }
            if (days >= jobDay) {
                count++;
            }
            if (days < jobDay) {
                answer.add(count);
                count = 1;
                days = jobDay;
            }
            
        }
        answer.add(count);
            
        return answer.stream().mapToInt(i->i).toArray();
    }
}