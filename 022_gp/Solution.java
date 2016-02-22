public class Solution {
    
    public static final String LEFT = "(";
    public static final String RIGHT = ")";
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(LEFT, n-1, n));
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.left == 0) {
                StringBuffer sb = new StringBuffer(node.str);
                for (int i= 0; i < node.right; i++) {
                    sb.append(RIGHT);
                }
                result.add(sb.toString());
            } else {
                stack.push(new Node(node.str + LEFT, node.left - 1, node.right));
                if (node.left <= node.right - 1) {
                    stack.push(new Node(node.str + RIGHT, node.left, node.right - 1));
                }
            }
        }
        return result;
    }
    
    public class Node {
        int left;
        int right;
        String str;
        
        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
}
