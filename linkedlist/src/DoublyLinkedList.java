/**
 * Created by amolp on 1/25/18.
 */
public class DoublyLinkedList {
    Node head;

    public void insertAtTop(int val) {
        Node node = new Node(val);
        if(head==null) {
            head = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void insetAtBottom(int val) {
        Node node = new Node(val);
        if(head==null) {
            head = node;
        } else {
            Node current = head;
            while(current != null && current.next!= null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
        }
    }

    public void delete(int val) {
        Node current = head;
        while(current!=null) {
            if(current.value==val) {
                Node prev = current.prev;
                if(prev!=null){
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                if(current.next != null) {
                    current.next.prev = prev;
                }
            }
            current = current.next;
        }
    }

    public void reverse() {
        if(head !=null && head.next!= null) {
            Node current = head;
            while(current!=null) {
                Node next = current.next;
                Node prev = current.prev;
                current.next = prev;
                current.prev = next;
                if(current.prev == null) {
                    head = current;
                }
                current = current.prev;
            }
        }
    }

    public void print() {
        Node current = head;
        if(current!=null) {
            while(current!=null) {
                System.out.print(current.value + "->");
                current=current.next;
            }
        }
        System.out.println();
    }


    public class Node {
        int value;
        Node prev;
        Node next;
        public Node(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.print();
        dll.reverse();
        dll.print();
        dll.insetAtBottom(9);
        dll.print();
        dll.insertAtTop(3);
        dll.print();
        dll.insertAtTop(6);
        dll.print();
        dll.insetAtBottom(5);
        dll.print();
        dll.insetAtBottom(7);
        dll.print();
        dll.delete(7);
        dll.print();
        dll.reverse();
        dll.print();
    }

}
