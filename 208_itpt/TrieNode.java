class TrieNode {
    char val;
    boolean wordEnd;
    Map<Character, TrieNode> children;
    // Initialize your data structure here.
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
}
