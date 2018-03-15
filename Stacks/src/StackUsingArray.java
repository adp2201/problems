
public class StackUsingArray {

    private int[] array;
    int rear = -1;

    public StackUsingArray(int size) {
        array = new int[size];
    }

    public int peek() {
        return array[rear];
    }

    public void push(int num) {
        rear++;
        array[rear] = num;
    }

    public int pop() {
        int index = rear;
        rear--;
        return array[index];
    }

    public int search(int num) {
        for(int i=rear; i>=0; i--) {
            if(array[i] == num) {
                return rear-i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return rear<0;
    }

    public void print() {
        for(int i=rear; i>=0; i--) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(10);
        stack.print();
        System.out.println(stack.isEmpty());
        stack.push(0);
        stack.print();
        stack.push(5);
        stack.print();
        stack.push(10);
        System.out.println("Index of 10 is " + stack.search(10));
        stack.print();
        stack.push(15);
        System.out.println("Index of 10 is " + stack.search(10));
        stack.print();
        stack.push(20);
        System.out.println("Index of 10 is " + stack.search(10));
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.search(10));
    }
}
