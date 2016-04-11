public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        boolean[] added = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ci = c - 'a';
            if (!added[ci]) {
                while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0) {
                    added[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                added[ci] = true;
            }
            counts[ci]--;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
