class MyQueue {
    private Stack inStack = new Stack();
    private Stack outStack = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                Object x = inStack.pop();
                outStack.push(x);
            }
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                Object x = inStack.pop();
                outStack.push(x);
            }
        }
        return (Integer)outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
