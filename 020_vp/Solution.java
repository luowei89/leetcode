public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                char open = stack.pop();
                if((open == '(' && c != ')')
                ||(open == '{' && c != '}')
                ||(open == '[' && c != ']')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}