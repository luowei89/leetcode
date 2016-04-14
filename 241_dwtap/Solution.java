public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || "".equals(input)) {
            return result;
        }
        List<Integer> lefts;
        List<Integer> rights;
        boolean number = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                number = false;
                lefts = diffWaysToCompute(input.substring(0,i));
                rights = diffWaysToCompute(input.substring(i + 1));
                for (int a : lefts) {
                    for (int b : rights) {
                        result.add(compute(a, b, input.charAt(i)));
                    }
                }
            }
        }
        if (number) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
    
     private int compute(int a, int b, char op) {
        switch (op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return -1; // wrong operator
        }
    }
}
