
public class DequeUsingLL {
    Node front;
    Node beforeLast;

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

    public void insertFront(int num) {
        Node node = new Node(num);
        if(front==null) {
            front = node;
        } else {
            node.next = front;
            front = node;
            if(beforeLast == null) {
                beforeLast = node;
            }
        }
    }

    public int removeFront() throws Exception {
        if(front==null) {
            throw new Exception("Empty deque");
        }
        Node node = front;
        front = front.next;
        if(beforeLast==node) {
            beforeLast = null;
        }
        return node.val;
    }

    public void insertLast(int num) {
        Node node = new Node(num);
        if(beforeLast==null) {
            if(front==null) {
                front = node;
            } else {
                front.next = node;
                beforeLast = front;
            }
        } else {
            beforeLast.next.next = node;
            beforeLast = beforeLast.next;
        }
    }

    //O(n)
    public int removeLast() throws Exception {
        if(beforeLast==null) {
            if(front==null) {
                throw new Exception("Empty Dequeue");
            } else {
                Node node = front;
                front=null;
                return node.val;
            }
        } else {
            Node node = beforeLast.next;
            beforeLast.next = null;
            Node curr = front;
            if(curr==beforeLast) {
                beforeLast=null;
            } else {
                //WHILE USING SINGLY LL, WE HAVE NO WAY TO DECREMENT THE BEFORELAST POINTER. HENCE, WE SHOULD USE DOUBLY LL to implemt DEQUE
                while(curr.next!= beforeLast) {
                    curr = curr.next;
                }
                beforeLast = curr;
            }
            return node.val;
        }
    }

    public static void main(String[] args) throws Exception {
        DequeUsingLL deque = new DequeUsingLL();
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
