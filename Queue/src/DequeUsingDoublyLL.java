public class DequeUsingDoublyLL {

    Node front;
    Node last;

    public class Node {
        int val;
        Node next;
        Node prev;
        public Node(int  val) {
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return front==null && last == null;
    }

    public void insertFront(int num) {
        Node node = new Node(num);
        if(front== null && last==null) {
            front=last=node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
    }

    public int removeFront() throws Exception {
        if(front== null && last==null) {
            throw new Exception("Empty Deque");
        } else {
            Node node = front;
            front = front.next;
            if(front==null) {
                last = null;
            } else {
                front.prev = null;
            }
            return node.val;
        }
    }

    public void insertLast(int num) {
        Node node = new Node(num);
        if(front==null && last == null) {
            front=last=node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public int removeLast() throws Exception {
        if(front==null && last==null) {
            throw new Exception("Empty Deque");
        } else {
            Node node = last;
            last = last.prev;
            if(last==null) {
                front=null;
            } else {
                last.next = null;
            }
            return node.val;
        }
    }

    public static void main(String[] args) throws Exception {
        DequeUsingDoublyLL deque = new DequeUsingDoublyLL();
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(0);
        System.out.println("IsEmpty : " + deque.isEmpty());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(1);
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(2);
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(3);
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());

        deque.insertFront(0);
        deque.insertFront(1);
        deque.insertFront(2);
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(0);
        deque.insertFront(1);
        deque.insertFront(2);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(0);
        deque.insertLast(1);
        deque.insertLast(2);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(0);
        deque.insertLast(1);
        deque.insertLast(2);
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
    }
}
