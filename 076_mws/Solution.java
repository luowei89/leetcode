public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // save characters count in t
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer count = charCount.get(c);
            if (count == null) {
                count = 0;
            }
            charCount.put(c, count + 1);
        }

        int start = 0;
        int end = -1;
        boolean startNext = true;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            while (start < s.length()) {
                char c = s.charAt(start);
                Integer count = charCount.get(c);
                if (count != null) {
                    if (allCovered(charCount)) {
                        int len = end - start + 1;
                        if (len < minLen) {
                            minLen = len;
                            minStart = start;
                        }
                    }
                    if (startNext) {
                        break;
                    } else {
                        count++;
                        startNext = count > 0;
                        charCount.put(c, count);
                    }
                }
                start++;
            }
            end++;
            if (end == -1) {
                end = start;
            }
            while (end < s.length()) {
                char c = s.charAt(end);
                Integer count = charCount.get(c);
                if (count != null) {
                    count--;
                    charCount.put(c, count);
                    if (count == 0) {
                        if (allCovered(charCount)) {
                            int len = end - start + 1;
                            if (len < minLen) {
                                minLen = len;
                                minStart = start;
                            }
                            startNext = false;
                            break;
                        }
                    }
                }
                end++;
            }
        }

        if (Integer.MAX_VALUE == minLen) {
            return "";
        } else {
            return s.substring(minStart, minStart + minLen);
        }
    }

    private boolean allCovered(Map<Character, Integer> charCount) {
        for (char c : charCount.keySet()) {
            if (charCount.get(c) > 0) {
                return false;
            }
        }
        return true;
    }
}
