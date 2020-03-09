package easy.stack;

import java.util.ArrayDeque;

/**
 * S_225
 *
 * @author hunan
 * @date 2020-03-01
 * @time 23:20
 */
public class MyStack {
    private ArrayDeque<Integer> queue;
    private ArrayDeque<Integer> tmp;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new ArrayDeque<>();
        tmp = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        while (!queue.isEmpty()) {
            tmp.offer(queue.poll());
        }
        queue.offer(x);

        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
