import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue1(int num) {
        while (!stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        stack1.push(num);
        while (!stack2.isEmpty()) {
            int val = stack2.pop();
            stack1.push(val);
        }
    }

    public int deque1() {
        return stack1.pop();
    }

    public void enqueue2(int num) {
        stack1.push(num);
    }

    public int deque2() {
        int num = Integer.MAX_VALUE;
        while (!stack1.isEmpty()) {
            num = stack1.pop();
            stack2.push(num);
        }
        stack2.pop();
        while (!stack2.isEmpty()) {
            int val = stack2.pop();
            stack1.push(val);
        }
        return num;
    }


    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue1(5);
        queue.enqueue1(10);
        queue.enqueue1(15);
        System.out.println(queue.deque1());
        System.out.println(queue.deque1());
        System.out.println(queue.deque1());
        queue.enqueue2(5);
        queue.enqueue2(10);
        queue.enqueue2(15);
        System.out.println(queue.deque2());
        System.out.println(queue.deque2());
        System.out.println(queue.deque2());
    }
}
