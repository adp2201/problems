
public class PriorityQueueUsingLL {

    Element head;

    public class Element {
        int num;
        int priority;
        Element next;

        public Element(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public void insert(int num, int priority) {
        Element element = new Element(num, priority);
        element.next = head;
        head = element;
    }

    public int getHighestPriority() throws Exception {
        if(head != null) {
            Element curr = head;
            int num = head.num;
            int priority = head.priority;
            curr = curr.next;
            while(curr != null) {
                if(curr.priority > priority) {
                    priority = curr.priority;
                    num = curr.num;
                }
                curr = curr.next;
            }
            return num;
        } else {
            throw new Exception("Empty Priority Queue");
        }
    }

    public void deleteHighestPriority() throws Exception {
        if(head != null) {
            Element curr = head;
            int num = head.num;
            int priority = head.priority;
            curr = curr.next;
            while(curr != null) {
                if(curr.priority > priority) {
                    priority = curr.priority;
                    num = curr.num;
                }
                curr = curr.next;
            }
            curr = head;
            if(curr.num == num) {
                head = head.next;
            } else {
                while(curr.next != null && curr.next.num != num) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
        } else {
            throw new Exception("Empty Priority Queue");
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueUsingLL priorityQueue = new PriorityQueueUsingLL();
        priorityQueue.insert(5,1);
        System.out.println(priorityQueue.getHighestPriority());
        priorityQueue.insert(10,2);
        System.out.println(priorityQueue.getHighestPriority());
        priorityQueue.insert(15,3);
        System.out.println(priorityQueue.getHighestPriority());
        priorityQueue.deleteHighestPriority();
        System.out.println(priorityQueue.getHighestPriority());
        priorityQueue.deleteHighestPriority();
        System.out.println(priorityQueue.getHighestPriority());
        priorityQueue.deleteHighestPriority();
        priorityQueue.insert(10,2);
        System.out.println(priorityQueue.getHighestPriority());
    }
}
