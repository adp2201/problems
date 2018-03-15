
public class CircularQueueUsingArray {
    int[] array;
    int front, last;

    public CircularQueueUsingArray(int size) {
        array = new int[size];
        front = -1;
        last = -1;
    }

    public boolean isEmpty() {
        return front==-1 && last==-1;
    }

    public void enqueue(int num) throws Exception{
        if(front==-1 && last==-1) {
            front++;
            last++;
            array[last]=num;
        } else if(last==array.length-1) {
            if(front==0) {
                throw new Exception("CircularQueue Full");
            } else {
                last = 0;
                array[last]=num;
            }
        } else {
            last++;
            array[last] = num;
        }
    }

    public int dequeue() throws Exception {
        if(front==-1 && last==-1) {
            throw new Exception("Circurlar Queue Empty");
        } else {
            int num = array[front];
            if(front==last) {
                front=-1;
                last=-1;
            } else if(front==array.length-1) {
                front=0;
            } else {
                front++;
            }
            return num;
        }
    }

    public static void main(String[] args) throws Exception {
        CircularQueueUsingArray circularQueue = new CircularQueueUsingArray(3);
        System.out.println(circularQueue.isEmpty());
        circularQueue.enqueue(0);
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.isEmpty());
        circularQueue.enqueue(0);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.isEmpty());
        circularQueue.enqueue(0);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.isEmpty());
    }
}
