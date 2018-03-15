
public class LinkedList2 {
    Node head;
    Node tail;
    int size;

    public LinkedList2() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList2(int data) {
        Node node = new Node(data);
        head = node;
        tail = node;
        size = 1;
    }

    public void addToTop(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = node;
        }
        size++;
    }

    public void addToBottom(int data) {
        Node node = new Node(data);
        if(tail != null) {
            tail.next = node;
        }
        tail = node;
        if(head == null) {
            head = node;
        }
        size++;
    }

    public void removeNodeIfExists(int data) {
        Node current = head;
        if(current != null) {
            if(current.data == data) {
                head = current.next;
                size--;
            } else {
                while(current.next != null) {
                    if(current.next.data == data) {
                        current.next = current.next.next;
                        size--;
                        if(current.next == null) {
                            tail = current;
                        }
                    }
                }
            }
        }
    }

    public void printList() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("Size : " + size);
    }

    public static void main (String[] args) {
        LinkedList2 list = new LinkedList2();
        System.out.println("Before adding");
        list.printList();
        list.addToTop(1);
        System.out.println("After adding");
        list.printList();
        list.addToTop(5);
        System.out.println("After adding 1");
        list.printList();
        list.removeNodeIfExists(1);
        System.out.println("After removing");
        list.printList();
        list.removeNodeIfExists(5);
        System.out.println("After removing");
        list.printList();
    }
}
