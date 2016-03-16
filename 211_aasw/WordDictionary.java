public class WordDictionary {

    private TrieNode root;
    private int minLen;
    private int maxLen;

    public WordDictionary() {
        root = new TrieNode();
        minLen = Integer.MAX_VALUE;
        maxLen = Integer.MIN_VALUE;
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int len = word.length();
        if (len < minLen) {
            minLen = len;
        }
        if (len > maxLen) {
            maxLen = len;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.addChild(c);
            node = node.getChild(c);
        }
        node.setWordEnd();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int len = word.length();
        if (len < minLen || len > maxLen) {
            return false;
        }
        List<TrieNode> list = new ArrayList<>();
        list.add(root);
        for (char c : word.toCharArray()) {
            List<TrieNode> newList = new ArrayList<>();
            if (c == '.') {
                for (TrieNode node : list) {
                    newList.addAll(node.getChildren());
                }
            } else {
                for (TrieNode node : list) {
                    if (node.getChild(c) != null) {
                        newList.add(node.getChild(c));
                    }
                }
            }
            list = newList;
            if (list.size() == 0) {
                return false;
            }
        }
        for (TrieNode node : list) {
            if (node.isWordEnd()) {
                return true;
            }
        }
        return false;
    }
    
    public class TrieNode {
        char val;
        boolean wordEnd;
        Map<Character, TrieNode> children;
        
        public TrieNode() {
            val = '-'; // root
            wordEnd = false;
            children = new HashMap<>();
        }
    
        public TrieNode(char val) {
            this.val = val;
            wordEnd = false;
            children = new HashMap<>();
        }
    
        public void addChild(char val) {
            if (children.get(val) == null) {
                children.put(val, new TrieNode(val));
            }
        }
    
        public TrieNode getChild(char val) {
            return children.get(val);
        }
        
        public void setWordEnd() {
            this.wordEnd = true;
        }
        
        public boolean isWordEnd() {
            return this.wordEnd;
        }
        
        public List<TrieNode> getChildren() {
            return new ArrayList(this.children.values());
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
