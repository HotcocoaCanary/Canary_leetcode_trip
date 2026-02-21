package code.J316;

import java.util.*;

public class J316 {
    ///给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] > 0) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
