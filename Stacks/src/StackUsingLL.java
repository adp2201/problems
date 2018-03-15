
public class StackUsingLL {
    Node head;

    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public int peek() {
        return head.val;
    }

    public int pop() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public int search(int num) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if(current.val == num) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print(current.val + " -> ");
    }

    public class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
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
