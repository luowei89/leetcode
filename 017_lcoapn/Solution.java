public class Solution {
    private static final String[][] mapping = {{"a","b","c"}, {"d","e","f"}, {"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        int digit = digits.charAt(0) - '2';
        if (digit < 0 || digit >= mapping.length) {
            return result;
        }
        String[] chars = mapping[digit];
        if (digits.length() == 1) {
            for (String c : chars) {
                result.add(c);
            }
            return result;
        }
        String remain = digits.substring(1);
        List<String> remains = letterCombinations(remain);
        for (String c : chars) {
            for (String r : remains) {
                result.add(c + r);
            }
        }
        return result;
    }
}
