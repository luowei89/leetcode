public class Solution {
    public String numberToWords(int num) {
        String[] words = {"Thousand ", "Million ", "Billion ", "Trillion "};
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (num > 0) {
            String section = toWords(num % 1000);
            stack.push(section);
            stack.push(words[i]);
            i++;
            num = num / 1000;
        }
        if(stack.isEmpty()) {
            return "Zero";
        }
        String lastSection = "";
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            String word = stack.pop();
            if (!"".equals(lastSection)) {
                sb.append(lastSection);
                sb.append(word);
            }
            lastSection = stack.pop();
        }
        sb.append(lastSection);
        return sb.toString().trim();
    }
    
    // to words 1~999, return "" for 0
    private String toWords(int num) {
        int[] digits = new int[3];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            digits[2-i] = num%10;
            num = num/10;
        }
        // hundred
        if (digits[0] > 0) {
            sb.append(digitToWord(digits[0]));
            sb.append("Hundred ");
        }
        if (digits[1] > 0) {
            sb.append(digitsToWord(digits[1], digits[2]));
        } else {
            sb.append(digitToWord(digits[2]));
        }
        return sb.toString();
    }
    
     // to word 1~99, return "" for 0
    private String digitsToWord(int ten, int digit) {
        String[] teens = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] tens = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        if (ten == 1) {
            return teens[digit];
        } else if (1< ten && ten < 10) {
            return tens[ten-2] + digitToWord(digit);
        } else {
            return "";
        }
    }
    
    // to word 1~9, return "" for 0
    private String digitToWord(int digit) {
        String[] words = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        if (digit > 0 && digit < 10) {
            return words[digit-1];
        } else {
            return "";
        }
    }
}
