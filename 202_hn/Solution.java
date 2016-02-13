public class Solution {
    
    private Set<Integer> set = new HashSet<>();
    
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        set.add(n);
        int newN = sumDigits(n);
        if (set.contains(newN)) {
            return false;
        } else {
            return isHappy(newN);
        }
    }
    
    private int sumDigits(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit*digit;
            n = n / 10;
        }
        return sum;
    }
}
