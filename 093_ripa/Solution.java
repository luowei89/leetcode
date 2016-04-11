public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        SearchNode root = new SearchNode("", s, 0);
        Stack<SearchNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            SearchNode node = stack.pop();
            if (node.segs == 4) {
                if ("".equals(node.remain)) {
                    ips.add(node.ipAddr.substring(1));
                }
            } else {
                if (node.remain.length() > 0) {
                    stack.push(new SearchNode(node.ipAddr + "." + node.remain.substring(0,1), 
                                                node.remain.substring(1), node.segs + 1));
                }
                if (node.remain.length() > 1 && !node.remain.startsWith("0")) {
                    stack.push(new SearchNode(node.ipAddr + "." + node.remain.substring(0,2), 
                                                node.remain.substring(2), node.segs + 1));
                }
                if (node.remain.length() > 2 && !node.remain.startsWith("0") 
                        && Integer.valueOf(node.remain.substring(0,3)) < 256) {
                    stack.push(new SearchNode(node.ipAddr + "." + node.remain.substring(0,3), 
                                                node.remain.substring(3), node.segs + 1));
                }
            }
        }
        return ips;
    }
    
    public class SearchNode {
        String ipAddr;
        String remain;
        int segs;
        public SearchNode(String ipAddr, String remain, int segs) {
            this.ipAddr = ipAddr;
            this.remain = remain;
            this.segs = segs;
        }
    }
}
