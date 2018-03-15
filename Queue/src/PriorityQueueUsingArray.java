
public class PriorityQueueUsingArray {

    Element[] elements;
    int start;
    int end;

    public PriorityQueueUsingArray(int size) {
        elements = new Element[size];
        start = 0;
        end = -1;
    }

    public class Element {
        int num;
        int priority;
        public Element(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public void insert(int num, int priority) throws Exception {
        if(end+1>=elements.length) {
            throw new Exception("Priority queue full");
        } else {
            elements[++end] = new Element(num, priority);
        }
    }

    public int getHighestPriority() throws Exception {
        if(start > end || start >=elements.length) {
            throw new Exception("Empty Priority Queue");
        }
        int index = start;
        int priority = elements[index].priority;
        for(int i=start+1 ; i<=end; i++) {
            if(elements[i].priority > priority) {
                index = i;
                priority = elements[i].priority;
            }
        }
        return elements[index].num;
    }

    public void deleteHighestPriority() throws Exception {
        if(start > end || start >=elements.length) {
            throw new Exception("Empty Priority Queue");
        }
        int index = start;
        int priority = elements[index].priority;
        for(int i=start+1 ; i<=end; i++) {
            if(elements[i].priority > priority) {
                index = i;
                priority = elements[i].priority;
            }
        }
        for(int i=index; i<end; i++) {
            elements[i] = elements[i+1];
        }
        end--;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueUsingArray priorityQueue = new PriorityQueueUsingArray(10);
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
