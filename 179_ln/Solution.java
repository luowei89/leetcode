public class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return sort(list);
    }
    
    private String sort(List<Integer> list) {
        if (list.size() == 0) {
            return "";
        }
        if (list.size() == 1) {
            return "" + list.get(0);
        }
        int mid = list.size() / 2;
		int pivot = list.get(mid);
		List<Integer> less = new ArrayList<>();
		List<Integer> equal = new ArrayList<>();
		List<Integer> greater = new ArrayList<>();
		for (int x : list) {
		    if (compare(x, pivot) < 0) {
		        less.add(x);
		    } else if (compare(x, pivot) > 0) {
		        greater.add(x);
		    } else {
		        equal.add(x);
		    }
		}
		StringBuffer sb = new StringBuffer();
		sb.append(sort(greater));
		for (int x : equal) {
		    sb.append(x);
		}
		sb.append(sort(less));
		String str = sb.toString();
		return str.startsWith("0") ? "0" : str;
    }
    
    private int compare(int x, int y) {
        if (x == y) {
            return 0;
        }
        Stack<Integer> stackX = toStack(x, y);
        Stack<Integer> stackY = toStack(y, x);
        Integer xDigit = stackX.pop();
        Integer yDigit = stackY.pop();
        Integer start = xDigit;
        while (xDigit != null && yDigit != null) {
            if (xDigit == yDigit) {
                xDigit = stackX.isEmpty() ? null : stackX.pop();
                yDigit = stackY.isEmpty() ? null : stackY.pop();
            } else {
                return xDigit - yDigit;
            }
        }
        return 0;
    }
    
    private Stack<Integer> toStack(int x, int y) {
        Stack<Integer> stack = new Stack<>();
        if (y == 0) {
            stack.push(0);
        }
        while (y > 0) {
            stack.push(y % 10);
            y = y / 10;
        }
        if (x == 0) {
            stack.push(0);
        }
        while (x > 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        return stack;
    }
}
