public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int n = words[0].length();
        if (s.length() < n*words.length) {
            return result;
        }
        Map<String, Integer> wordsCount = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            Integer count = wordsCount.get(words[i]);
            if (count == null) {
                count = 0;
            }
            wordsCount.put(words[i], count + 1);
        }
        for (int i = 0; i < n; i++) {
            int start = -1;
            int end = i;
            while (end < s.length() - n + 1) {
                if (start != -1 && end - start == n * words.length) {
                    result.add(start);
                    Node startNode = queue.poll();
                    wordsCount.put(startNode.getStr(), wordsCount.get(startNode.getStr()) + 1);
                    start += n;
                }
                String str = s.substring(end, end + n);
                Integer count = wordsCount.get(str);
                if (count != null) {
                    if (count == 0) {
                        Node node = queue.poll();
                        while (!node.getStr().equals(str)) {
                            wordsCount.put(node.getStr(), wordsCount.get(node.getStr()) + 1);
                            node = queue.poll();
                        }
                        wordsCount.put(node.getStr(), wordsCount.get(node.getStr()) + 1);
                        start = node.getIndex() + n;
                    }
                    if (start == -1) {
                        start = end;
                    }
                    queue.add(new Node(str, end));
                    wordsCount.put(str, wordsCount.get(str) - 1);
                    end += n;
                } else {
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        wordsCount.put(node.getStr(), wordsCount.get(node.getStr()) + 1);
                    }
                    start = -1;
                    end += n;
                }
            }
            if (start != -1 && end - start == n * words.length) {
                result.add(start);
            }
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                wordsCount.put(node.getStr(), wordsCount.get(node.getStr()) + 1);
            }
        }
        return result;
    }

    public class Node {
        private String str;
        private int index;

        public Node(String str, int index) {
            this.str = str;
            this.index = index;
        }

        public String getStr() {
            return str;
        }

        public int getIndex() {
            return index;
        }
    }
}
