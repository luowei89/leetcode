/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> itrStack;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        itrStack = new Stack<>();
        itrStack.push(nestedList.iterator());
        while (!itrStack.isEmpty() && !itrStack.peek().hasNext()) {
            itrStack.pop();
        }
        next = getNext();
    }

    private Integer getNext() {
        if (itrStack.isEmpty()) {
            return null;
        }
        NestedInteger ni = itrStack.peek().next();
        while (!ni.isInteger()) {
            itrStack.push(ni.getList().iterator());
            while (!itrStack.peek().hasNext()) {
                itrStack.pop();
                if (itrStack.isEmpty()) {
                    return null;
                }
            }
            ni = itrStack.peek().next();
        }
        while (!itrStack.isEmpty() && !itrStack.peek().hasNext()) {
            itrStack.pop();
        }
        return ni.getInteger();
    }

    @Override
    public Integer next() {
        Integer theNext = next;
        next = getNext();
        return theNext;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
