import java.util.HashMap;

public class LRU {
    HashMap<Integer, Node> map;
    Node front;
    Node back;
    int size;

    public LRU(int size) {
        map = new HashMap<>();
        front = back = null;
        this.size = size;
    }

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void insert(int key, int value) {
        if(map.size() == size) {
            deleteBack();
        }
        if(map.keySet().contains(key)) {
            Node node = map.get(key);
            if(node!=null) deleteNode(node);
        }
        Node newNode = new Node(key, value);
        insertFront(newNode);
        map.put(key, newNode);
    }

    public int get(int key) {
        if(map.keySet().contains(key)) {
            Node node = map.get(key);
            if(node!=null) deleteNode(node);
            insertFront(node);
            return node.val;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void  delete(int key) {
        if(map.keySet().contains(key)) {
            Node node = map.get(key);
            if (node != null) deleteNode(node);
            map.remove(key);
        }
    }

    public void deleteNode(Node node) {
        if(node.prev!=null) node.prev.next = node.next;
        if(node.next!=null) node.next.prev = node.prev;
    }

    public void insertFront(Node node) {
        if(front==null && back==null) {
            front=back=node;
        } else {
            node.next = front.next;
            node.prev = front.prev;
            front = node;
        }
    }

    public void deleteBack() {
        if(back.prev!=null) back.prev.next = null;
        map.remove(back.key);
        back = back.prev;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(4);
        System.out.println(lru.get(0));
        lru.insert(0,100);
        System.out.println(lru.get(0));
        lru.insert(1,101);
        System.out.println(lru.get(1));
        lru.insert(2,102);
        System.out.println(lru.get(2));
        lru.insert(3,103);
        System.out.println(lru.get(3));
        lru.delete(1);
        lru.insert(4,104);
        System.out.println(lru.get(4));
        System.out.println(lru.get(0));
        System.out.println(lru.get(1));
    }
}
