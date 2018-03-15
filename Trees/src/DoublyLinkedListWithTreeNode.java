
public class DoublyLinkedListWithTreeNode {
    Node head, rear;

    public void insertNodeAtRear(Node node) {
        if(head==null || rear==null) {
            head=rear=node;
        } else {
            rear.right = node;
            node.left = rear;
            rear = node;
        }
    }

    public void  print() {
        Node node = head;
        while(node!=null) {
            System.out.print(node.val + ",");
            node = node.right;
        }
    }
}
