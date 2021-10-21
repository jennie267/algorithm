package programmers.hash.phonenumber;

import java.util.Arrays;

/**
 * 전화번호 목록
 * level2
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phoneBook1 = {"119", "97674223", "1195524421"};
        System.out.println(solution.solution(phoneBook1));      // false
        String[] phoneBook2 = {"123", "456", "789"};
        System.out.println(solution.solution(phoneBook2));      // true
        String[] phoneBook3 = {"12", "123", "1235", "567", "88"};
        System.out.println(solution.solution(phoneBook3));      // false
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++){
            if (phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}