/**
 * Created by amolp on 1/19/18.
 */
public class LinkedListImp {
    Node head;

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

    public void print() {
        Node current = this.head;
        while(current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addAtTail(int value) {
        Node nextNode = new Node(value);
        if(this.head == null) {
            this.head = nextNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nextNode;
        }
    }

    public void addAtHead(int value) {
        Node node = new Node(value);
        if(this.head == node) {
            this.head = node;
        } else {
            node.next = this.head;
            head = node;
        }
    }

    public void reverse() {
        Node previous = null;
        Node current = this.head;

        if(current != null ) {
            while(current.next != null) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            current.next = previous;
            this.head = current;
        }
    }

    public void addAfter(int after, int value) {
        Node node = new Node(value);
        Node current = this.head;
        if(current != null ) {
            while(current != null && current.value != after) {
                current = current.next;
            }
            if(current != null) {
                Node next = current.next;
                node.next = next;
                current.next = node;
            }
        }
    }

    public void delete(int value) {
        Node current = this.head;
        Node prev = null;
        if(this.head.value == value) {
            this.head = this.head.next;
        } else {
            while(current != null && current.value != value) {
                prev = current;
                current = current.next;
            }
            if(current!= null) {
                prev.next = current.next;
            }
        }
    }

    public Node get(int index) {
        Node current = head;
        for(int i=0; i < index; i++) {
            if(current != null) {
                current = current.next;
            }
        }
        return current;
    }

    public int length() {
        Node current = head;
        int length = 0;
        while(current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    public void swap(int val1, int val2) {
        if(val1 == val2) {
            return;
        }
        Node current = head;
        boolean val1Done = false;
        boolean val2Done = false;
        Node prevVal1 = null;
        Node curVal1 = null;
        Node prevVal2 = null;
        Node curVal2 = null;
        while (current != null && (!val1Done || !val2Done)) {
            if(current.value == val1) {
                curVal1 = current;
                val1Done = true;
            }
            if(current.value == val2) {
                curVal2 = current;
                val2Done = true;
            }
            if(!val1Done) {
                prevVal1 = current;
            }
            if(!val2Done) {
                prevVal2 = current;
            }
            current = current.next;
        }
        Node val1Next = curVal1.next;
        Node val2Next = curVal2.next;
        curVal1.next = val2Next;
        curVal2.next = val1Next;
        if(prevVal1 == null) {
            head = curVal2;
        } else {
            prevVal1.next = curVal2;
        }
        if(prevVal2 == null) {
            head = curVal2;
        } else {
            prevVal2.next = curVal1;
        }
    }

    public Node getMiddleNode() {
        Node current = head;
        Node fast = head.next;
        while(fast != null) {
            current = current.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return current;
    }
    public Node getNthFromEnd(int n) {
        Node current = head;
        for(int i=0; i<n; i++) {
            current = current.next;
        }
        Node nthFromEnd = head;
        while(current.next != null) {
            current = current.next;
            nthFromEnd = nthFromEnd.next;
        }
        return nthFromEnd;
    }

    public boolean containsCycle() {
        if(head ==null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public void mergeSortedLinkedList(Node head2) {
        Node current1 = head;
        Node current2 = head2;
        if(head2 != null) {
            if(head2.value < head.value) {
                head = head2;
                current2 = current2.next;
            } else {
                current1 = current1.next;
            }
            Node current = head;
            while (current1 != null && current2 != null) {
                if(current1.value < current2.value) {
                    current.next = current1;
                    current1 = current1.next;
                } else {
                    current.next = current2;
                    current2 = current2.next;
                }
                current = current.next;
            }
            if(current1 != null) {
                current.next = current1;
            } else {
                current.next = current2;
            }
        }
    }

    public Node addNumbers(Node[] heads) {
        int n = heads.length;
        Node[] currs = new Node[n];
        for(int i=0; i<n; i++) {
            currs[i]=heads[i];
        }
        int sum=0;
        int carry=0;
        for(int i=0; i<n; i++) {
            Node curr = currs[i];
            sum+=curr==null?0:curr.value;
        }
        if(sum>9) {
            carry=sum/10;
        }
        Node adn = new Node(sum%10);
        for(int i=0; i<n; i++) {
            currs[i] = currs[i]!=null?currs[i].next:null;
        }
        boolean finished=false;
        for(int i=0; i<n; i++) {
            finished = finished || currs[i]!=null;
        }
        Node currAdn = adn;
        while (finished) {
            int currSum=carry;
            for(int i=0; i<n; i++) {
                Node curr = currs[i];
                currSum+=curr==null?0:curr.value;
            }
            carry=0;
            if(currSum>9) {
                carry = currSum/10;
            }
            currAdn.next = new Node(currSum%10);
            for(int i=0; i<n; i++) {
                currs[i] = currs[i]!=null?currs[i].next:null;
            }
            currAdn = currAdn.next;
            finished=false;
            for(int i=0; i<n; i++) {
                finished = finished || currs[i]!=null;
            }
        }
        while (carry>9) {
            currAdn.next = new Node(carry%10);
            carry=carry/10;
            currAdn = currAdn.next;
        }
        if(carry>0) currAdn.next = new Node(carry);
        return adn;
    }

    public static void main(String[] args) {
//        LinkedListImp linkedListImp = new LinkedListImp();
//        linkedListImp.print();
//        linkedListImp.reverse();
//        linkedListImp.print();
//        System.out.println(linkedListImp.length());
//        linkedListImp.addAtHead(0);
//        System.out.println(linkedListImp.length());
//        linkedListImp.addAtHead(5);
//        System.out.println(linkedListImp.length());
//        linkedListImp.addAtHead(10);
//        linkedListImp.addAtHead(15);
//        linkedListImp.print();
//        linkedListImp.reverse();
//        linkedListImp.print();
//        linkedListImp.addAfter(15, 20);
//        System.out.println(linkedListImp.length());
//        linkedListImp.print();
//        linkedListImp.addAfter(10, 12);
//        linkedListImp.print();
//        linkedListImp.addAfter(0, 1);
//        System.out.println(linkedListImp.length());
//        linkedListImp.print();
//        linkedListImp.addAfter(30, 31);
//        linkedListImp.print();
//        linkedListImp.delete(12);
//        linkedListImp.print();
//        linkedListImp.delete(12);
//        linkedListImp.print();
//        linkedListImp.delete(20);
//        linkedListImp.print();
//        linkedListImp.delete(0);
//        linkedListImp.print();
//        System.out.println(linkedListImp.get(0).value);
//        System.out.println(linkedListImp.length());
//        linkedListImp.swap(5, 15);
//        linkedListImp.print();
//        linkedListImp.swap(1, 10);
//        linkedListImp.print();
//
//        LinkedListImp linkedListImp2 = new LinkedListImp();
//        linkedListImp2.addAtTail(0);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        System.out.println("getNthFromEnd : " + linkedListImp2.getNthFromEnd(0).value);
//        linkedListImp2.addAtTail(1);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        System.out.println("getNthFromEnd : " + linkedListImp2.getNthFromEnd(1).value);
//        linkedListImp2.addAtTail(2);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        System.out.println("getNthFromEnd : " + linkedListImp2.getNthFromEnd(1).value);
//        linkedListImp2.addAtTail(3);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        System.out.println("getNthFromEnd : " + linkedListImp2.getNthFromEnd(2).value);
//        linkedListImp2.addAtTail(4);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        System.out.println("getNthFromEnd : " + linkedListImp2.getNthFromEnd(0).value);
//        linkedListImp2.addAtTail(5);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//        linkedListImp2.addAtTail(6);
//        linkedListImp2.print();
//        System.out.println(linkedListImp2.getMiddleNode().value);
//
//        System.out.println(linkedListImp2.containsCycle());
//
//        LinkedListImp list2 = new LinkedListImp();
//        list2.addAtTail(0);
//        list2.addAtTail(5);
//        list2.addAtTail(10);
//        list2.addAtTail(15);
//        linkedListImp2.print();
//        list2.print();
//        linkedListImp2.mergeSortedLinkedList(list2.head);
//        linkedListImp2.print();

        LinkedListImp list1 = new LinkedListImp();
        list1.addAtTail(9);
        list1.addAtTail(9);
        list1.addAtTail(9);
        list1.addAtTail(9);
        list1.addAtTail(9);
        list1.print();


        LinkedListImp list2 = new LinkedListImp();
        list2.addAtTail(9);
        list2.addAtTail(9);
        list2.addAtTail(9);
        list2.addAtTail(9);
        list2.addAtTail(9);
        //list2.addAtTail(1);
        list2.print();

        LinkedListImp list3 = new LinkedListImp();
        list3.addAtTail(9);
        list3.addAtTail(9);
        list3.addAtTail(9);
        list3.addAtTail(9);
        list3.addAtTail(9);
        list3.print();

        LinkedListImp list4 = new LinkedListImp();
        list4.addAtTail(9);
        list4.addAtTail(9);
        list4.addAtTail(9);
        list4.addAtTail(9);
        list4.addAtTail(9);
        list4.print();

        LinkedListImp list5 = new LinkedListImp();
        list5.addAtTail(9);
        list5.addAtTail(9);
        list5.addAtTail(9);
        list5.addAtTail(9);
        list5.addAtTail(9);
        list5.addAtTail(9);
        list5.print();

        Node[] nodes = new Node[5];
        nodes[0] = list3.head;
        nodes[1] = list4.head;
        nodes[2] = list2.head;
        nodes[3] = list1.head;
        nodes[4] = list5.head;

        LinkedListImp list6 = new LinkedListImp();
        Node sum = list6.addNumbers(nodes);
        list6.head = sum;
        list6.print();
    }
}
