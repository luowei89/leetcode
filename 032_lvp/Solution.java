public class Solution {
    // O(n)
    public int longestValidParentheses(String s) {
        int longest = 0;
        int n = s.length();
        boolean[] valid = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    valid[start] = valid[i] = true;
                }
            }
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                current++;
            } else {
                longest = Math.max(current, longest);
                current = 0;
            }
        }
        return Math.max(current, longest);
    }
}
