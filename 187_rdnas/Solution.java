public class Solution {
    
    private static int SEQ_LENGTH = 10;
    // Code the four letters: A:00, C:01, G:10, T:11
    private static Map<Character, Integer> dict = new HashMap<>();
    private static int mask = 0;
    static {
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);
        for (int i = 0; i < SEQ_LENGTH - 1; i++) {
            mask <<= 2;
            mask += 3;
        }
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int codeLength = s.length() - SEQ_LENGTH + 1;
        if (codeLength<= 0) {
            return result;
        }
        int[] codes = new int[codeLength];
        // init codes[0]
        for (int i = 0; i < SEQ_LENGTH; i++) {
            codes[0] <<= 2;
            // Non-valid character will cause NullPointerException
            codes[0] += dict.get(s.charAt(i));
        }
        for (int i = 1; i < codeLength; i++) {
            int newCode = codes[i-1];
            newCode &= mask;
            newCode <<= 2;
            newCode += dict.get(s.charAt(i+SEQ_LENGTH-1));
            codes[i] = newCode;
        }
        Set<Integer> codeSeen = new HashSet<>();
        Set<String> seqs = new HashSet<>();
        for (int i = 0; i < codeLength; i++) {
            if (codeSeen.contains(codes[i])) {
                seqs.add(s.substring(i,i+SEQ_LENGTH));
            } else {
                codeSeen.add(codes[i]);
            }
        }
        result.addAll(seqs);
        return result;
    }
}
