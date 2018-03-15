
public class LinkedList {
    private Node top;

    public LinkedList() {
        top = null;
    }

    public Node insertNodeAtTop(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        return newNode;
    }

    public Node insertNodeAtBottom(int data) {
        Node current = top;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
        return newNode;
    }

    public Node removeNode(int data) {
        Node current = top;
        Node removedNode = null;
        while(current.next != null) {
            if(current.next.data == data) {
                removedNode = current.next;
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return removedNode;
    }

    public void printLinkedList() {
        Node current = top;
        while(current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public void reverseLinkedList() {
        if(top.next != null) {
            Node iter1 = top;
            Node iter2 = iter1.next;
            Node current = iter2.next;
            iter1.next = null;
            while(current != null) {
                iter2.next = iter1;
                iter1 = iter2;
                iter2 = current;
                current = current.next;
            }
            iter2.next = iter1;
            top = iter2;
        }
    }

    public void reverseLinkedListRecursive() {
        if(top.next != null) {
            Node iter1 = top;
            Node iter2 = iter1.next;
            recursiveReverseHelper(iter1, iter2);
        }
    }

    public void recursiveReverseHelper(Node iter1, Node iter2) {
        if(iter2 == null) {
            top = iter1;
        } else {
            recursiveReverseHelper(iter1.next, iter2.next);
            iter2.next = iter1;
        }

        iter1.next = null;
    }

    public void insertNodeToSortedList2(int data) {
        if(top == null) {
            top = new Node(data);
        } else {
            Node current = top;
            while(current.next != null && data < current.next.data ) {
                current = current.next;
            }
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void insertNodeToSortedList3(int data) {
        Node newNode = new Node(data);
        if(top == null) {
            top = newNode;
        } else{
            Node current = top;
            if(current.next == null) {
                if(current.data > data) {
                    newNode.next = current;
                    top = newNode;
                } else {
                    newNode.next = current.next;
                    current.next = newNode;
                }
            } else {
                while(current.next != null && data > current.next.data ) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public void insertNodeToSortedList(int data) {
        Node newNode = new Node(data);
        if(top == null) {
            top = newNode;
        } else {
            if(top.data > data) {
                newNode.next = top;
                top = newNode;
            } else {
                Node prev = top;
                Node current = top.next;
                while(current != null && data > current.data) {
                    current = current.next;
                    prev = prev.next;
                }
                prev.next = newNode;
                newNode.next = current;
            }

        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNodeAtTop(5);
//        linkedList.insertNodeAtTop(10);
//        linkedList.insertNodeAtTop(15);
//        linkedList.insertNodeAtTop(20);
//        linkedList.insertNodeAtTop(25);
//        linkedList.insertNodeAtTop(30);
//        linkedList.insertNodeAtBottom(0);
        System.out.println("Original list");
        linkedList.printLinkedList();
        linkedList.reverseLinkedList();
        System.out.println("Post reversal list");
        linkedList.printLinkedList();
        linkedList.reverseLinkedListRecursive();
        System.out.println("Post recursive reversal list");
        linkedList.printLinkedList();
        linkedList.removeNode(20);
        linkedList.printLinkedList();

        LinkedList sortedLinkedList = new LinkedList();
        sortedLinkedList.insertNodeToSortedList(500);
        sortedLinkedList.insertNodeToSortedList(300);
        sortedLinkedList.reverseLinkedList();
        sortedLinkedList.insertNodeToSortedList(900);
        sortedLinkedList.insertNodeToSortedList(100);
        sortedLinkedList.insertNodeToSortedList(1000);
        sortedLinkedList.printLinkedList();
    }

}
