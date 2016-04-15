public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        for (String word : words) {
            if (length + word.length() + 1 > maxWidth && length > 0) {
                int n = line.size();
                StringBuffer sb = new StringBuffer();
                if (n == 1) {
                    sb.append(line.get(0));
                    while (length < maxWidth) {
                        sb.append(" ");
                        length++;
                    }
                } else {
                    int spaces = (maxWidth - length) / (n - 1) + 1;
                    int moreSpaces = (maxWidth - length) % (n - 1);
                    for (int i = 0; i < n; i++) {
                        sb.append(line.get(i));
                        if (i < n - 1) {
                            for (int j = 0; j < spaces; j++) {
                                sb.append(" ");
                            }
                        }
                        if (i < moreSpaces) {
                            sb.append(" ");
                        }
                    }
                }
                lines.add(sb.toString());
                line = new ArrayList<>();
                length = 0;
            }
            if (length > 0) {
                length += 1;
            }
            line.add(word);
            length += word.length();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < line.size() - 1) {
                sb.append(" ");
            }
        }
        while (length < maxWidth) {
            sb.append(" ");
            length++;
        }
        lines.add(sb.toString());
        return lines;
    }
}
