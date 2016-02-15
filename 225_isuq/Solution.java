class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        if (q1.isEmpty()) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q1.isEmpty()) {
            pop(q1, q2);
        } else {
            pop(q2, q1);
        }
    }
    
    // at any point of time, there should be one empty queue
    private void pop(Queue emptyQueue, Queue nonEmptyQueue) {
        while(nonEmptyQueue.size() > 1) {
            Object x = nonEmptyQueue.poll();
            emptyQueue.add(x);
        }
        nonEmptyQueue.poll();
    }

    // Get the top element.
    public int top() {
        if (q1.isEmpty()) {
            return top(q1, q2);
        } else {
            return top(q2, q1);
        }
    }
    
    // at any point of time, there should be one empty queue
    private int top(Queue emptyQueue, Queue nonEmptyQueue) {
        while(nonEmptyQueue.size() > 1) {
            Object x = nonEmptyQueue.poll();
            emptyQueue.add(x);
        }
        int val = (Integer)nonEmptyQueue.poll();
        emptyQueue.add(val);
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
