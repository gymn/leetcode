package easy.stack;

import java.util.Stack;
import java.util.TreeMap;

public class MinStack {
    private Stack<Integer> stack;
    private TreeMap<Integer, Integer> treeMap;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        treeMap = new TreeMap<>();
    }

    public void push(int x) {
        stack.push(x);
        treeMap.put(x, treeMap.getOrDefault(x,0)+1);
    }

    public void pop() {
        int n = stack.pop();
        int count = treeMap.get(n);
        if(count>1){
            treeMap.put(n, count-1);
        }else{
            treeMap.remove(n);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return treeMap.firstKey();
    }
}
