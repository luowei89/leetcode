public class Solution {
    private static final String SEPARATOR = "/";
    private static final String SELF = ".";
    private static final String PARENT = "..";
    public String simplifyPath(String path) {
        String[] paths = path.split(SEPARATOR);
        Stack<String> pathStack = new Stack<>();
        for (String p : paths) {
            if (PARENT.equals(p)) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else if (SELF.equals(p) || "".equals(p)) {
                continue;
            } else {
                pathStack.push(p);
            }
        }
        if(pathStack.isEmpty()) {
            return SEPARATOR;
        }
        Stack<String> resultStack = new Stack<>();
        while (!pathStack.isEmpty()) {
            String p = pathStack.pop();
            resultStack.push(p);
        }
        StringBuffer sb = new StringBuffer();
        while(!resultStack.isEmpty()) {
            sb.append(SEPARATOR);
            String p = resultStack.pop();
            sb.append(p);
        }
        return sb.toString();
    }
}
