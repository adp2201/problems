/**
 * Created by amolp on 1/24/18.
 */
public class CircularLinkedList {

    Node last;

    public void print() {
        if(last != null) {
            Node current = last.next;
            do {
                System.out.print(current.value + "->");
                current = current.next;
            } while (current != last.next);
        }
        System.out.println();
    }

    public void addNodeAtStart(int val) {
        Node node = new Node(val);
        if(last == null) {
            last = node;
            node.next = last;
        } else {
            Node a = last.next;
            last.next = node;
            node.next = a;
        }
    }

    public void addNodeAtEnd(int val) {
        Node node = new Node(val);
        if(last == null) {
            last = node;
            node.next = last;
        } else {
            Node a = last.next;
            last.next = node;
            node.next = a;
            last = node;
        }
    }

    public void sortedInsert(int val) {
        Node node = new Node(val);
        if(last==null) {
            last = node;
            node.next = last;
        } else {
            Node current = last.next;
            if(val < current.value) {
                Node a = last.next;
                last.next = node;
                node.next = a;
            } else {
                do {
                    if(current.next.value > val) {
                        Node a = current.next;
                        node.next = a;
                        current.next = node;
                        return;
                    }
                    current = current.next;
                } while (current!=last.next);
                Node a = last.next;
                node.next = a;
                last.next = node;
                last = node;
            }
        }
    }

    public void delete(int val) {
        Node current = last.next;
        if(current.value == val) {
            last.next = current.next;
        }
        do {
            if(current.next.value == val) {
                current.next = current.next.next;
            }
            current = current.next;
        } while (current != last.next);
    }

    public Node halves() {
        Node first = last.next;
        Node fast = first.next;
        Node slow = first;
        //Node current = first;
        if (fast.next == first) {
            slow.next = slow;
            fast.next = fast;
            return slow;
        }
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != last && fast != last.next);
        Node first2 = slow.next;
        slow.next = first;
        fast = last;
        fast.next = first2;
        //LinkedList starting from first, ending at slow is first.
        //LinkedList starting from first2, ending at fast is 2nd.
        return slow;
    }

    public int length() {
        if(last==null) {
            return 0;
        }
        Node current = last.next;
        int count = 0;
        do {
            current = current.next;
            count++;
        } while (current != last.next);
        return count;
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
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.sortedInsert(0);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.sortedInsert(2);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.sortedInsert(4);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.sortedInsert(3);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.sortedInsert(-1);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.delete(3);
        linkedList.print();
        System.out.println(linkedList.length());
        linkedList.delete(4);
        linkedList.print();
        System.out.println(linkedList.length());

//        Node node2 = linkedList.halves();
//        CircularLinkedList linkedList2 = new CircularLinkedList();
//        linkedList2.last = node2;
//        linkedList.print();
//        linkedList2.print();
    }
}
