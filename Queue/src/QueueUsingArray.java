
public class QueueUsingArray {
    int[] array;
    int start;
    int end;
    public QueueUsingArray(int size) {
        array = new int[size];
        start = 0;
        end = -1;
    }

    public boolean isEmpty() {
        return start>end;
    }

    public int dequeue() throws Exception {
        if(start<=end) {
            int num = array[start];
            start++;
            return num;
        } else {
            throw new Exception("Empty Queue");
        }
    }

    public void enqueue(int num) throws Exception {
        if(start>=array.length || end>=array.length) {
            throw new Exception("Queue Array Full");
        } else {
            if(end+1>=array.length) {
                throw new Exception("Queue Array Full");
            } else {
                array[++end] = num;
            }
        }
    }

    public int getFront() throws Exception {
        if(start > end || end>=array.length) {
            throw new Exception("Empty Queue");
        } else  return array[end];
    }

    public int getRear() throws Exception {
        if(start > end || start>=array.length) {
            throw new Exception("Empty Queue");
        } else  return array[start];
    }

    public static void main(String[] args) throws Exception {
        QueueUsingArray queue = new QueueUsingArray(10);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
        System.out.println("getFront" + queue.getFront());
        System.out.println("getRear" + queue.getRear());
        System.out.println(queue.dequeue());
    }
}
