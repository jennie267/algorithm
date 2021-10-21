package programmers.hash.cover;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

/**
 * 위장
 * level 2
 * 람다로 작성된 다른 사람 소스
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Cover_Stream {
    public static void main(String[] args) {
        SolutionStream solution = new SolutionStream();
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution.solution(clothes1));        // 5
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution.solution(clothes2));        // 3

    }
}

class SolutionStream {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1))
                .intValue() - 1;
    }
}