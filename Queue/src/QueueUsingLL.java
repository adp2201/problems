
public class QueueUsingLL {

    Node front;
    Node rear;

    public class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return front==null;
    }

    public void enqueue(int num) {
        Node node = new Node(num);
        if(rear != null) {
            rear.next = node;
        } else {
            front = node;
        }
        rear = node;
    }

    public int dequeue() throws Exception {
        if(front != rear.next && front != null && rear != null) {
            Node node = front;
            front = front.next;
            if(front==null) {
                rear = null;
            }
            return node.val;
        } else {
            throw new Exception("Empty queue");
        }
    }

    public int getFront()  throws Exception {
        if(front != rear.next && front != null && rear != null) {
            return front.val;
        } else {
            throw new Exception("Empty queue");
        }
    }

    public int getRear()  throws Exception {
        if(front != rear.next && front != null && rear != null) {
            return rear.val;
        } else {
            throw new Exception("Empty queue");
        }
    }

    public static void main(String[] args) throws Exception {
        QueueUsingLL queue = new QueueUsingLL();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
    }
}
