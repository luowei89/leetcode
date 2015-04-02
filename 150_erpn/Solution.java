public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            String token = tokens[i];
            if(token.equals("+")){
                int n = stack.pop() + stack.pop();
                stack.push(n);
            }
            else if(token.equals("-")){
                int base = stack.pop();
                int n = stack.pop() - base;
                stack.push(n);
            }
            else if(token.equals("*")){
                int n = stack.pop() * stack.pop();
                stack.push(n);
            }
            else if(token.equals("/")){
                int base = stack.pop();
                int n = stack.pop() / base;
                stack.push(n);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}