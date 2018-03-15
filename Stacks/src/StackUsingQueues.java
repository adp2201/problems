import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class StackUsingQueues {
    Queue<Integer> queue1 = new ArrayBlockingQueue<Integer>(10);
    Queue<Integer> queue2 = new ArrayBlockingQueue<Integer>(10);

    public void push1(int num) {
        queue1.add(num);
    }

    public int pop1() {
        int num = Integer.MAX_VALUE;

        while (!queue1.isEmpty()) {
            num = queue1.poll();
            if(!queue1.isEmpty()) queue2.add(num);
        }
        while (!queue2.isEmpty()) {
            int val = queue2.poll();
            queue1.add(val);
        }
        return num;
    }

    public void push2(int num) {
        while (!queue1.isEmpty()) {
            int val = queue1.poll();
            queue2.add(val);
        }
        queue1.add(num);
        while (!queue2.isEmpty()) {
            int val = queue2.poll();
            queue1.add(val);
        }
    }

    public int pop2() {
        return queue1.poll();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push1(5);
        stack.push1(15);
        stack.push1(25);
        stack.push1(35);
        stack.push1(45);
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());

        stack.push2(5);
        stack.push2(15);
        stack.push2(25);
        stack.push2(35);
        stack.push2(45);
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
    }

}
