/**
 * Created by amolp on 1/25/18.
 */
public class CircularQueue {
    Node front;
    Node rear;

    public void enqueue(int val) {
        Node node = new Node(val);
        if(rear==null) {
            rear = node;
            front = node;
            rear.next = front;
        } else {
            node.next = front;
            rear.next = node;
            rear = node;
        }
    }

    public void dequeue() {
        if(front != null) {
            if(front == rear) {
                front=rear=null;
            } else {
                rear.next = front.next;
                front = front.next;
            }
        }
    }

    public void print() {
        Node current = front;
        if(current!= null) {
            do {
                System.out.print(current.value + "->");
                current = current.next;
            } while (current!=front);
        }
        System.out.println();
    }

    public class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.enqueue(10);
        queue.print();
        queue.enqueue(1);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
    }
}
