public class Palindrome {
    public ListNode head;
    public void addAtTail(int value) {
        ListNode nextNode = new ListNode(value);
        if(this.head == null) {
            this.head = nextNode;
        } else {
            ListNode current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nextNode;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        ListNode curr = head;
        int size=0;
        while(curr!=null) {
            curr = curr.next;
            size++;
        }
        ListNode a = head;
        int count=1;
        while(count<size/2) {
            a = a.next;
            count++;
        }
        if(size%2==0) {
            ListNode lastFirstHalf = a;
            ListNode reversedList = reverse(lastFirstHalf.next);
            lastFirstHalf.next = null;
            return compare(head, reversedList);
        } else {
            ListNode beforeMiddle = a;
            ListNode middle = a.next;
            ListNode reversedList = reverse(middle.next);
            beforeMiddle.next=null;
            return compare(head, reversedList);
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean compare(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while(curr1!=null && curr2!=null) {
            if(curr1==null || curr2==null) {
                return false;
            }
            if(curr1.val!=curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome a = new Palindrome();
        a.addAtTail(1);
        a.addAtTail(0);
        a.addAtTail(1);
        System.out.println(isPalindrome(a.head));
    }
}