
public class DequeUsingArray {
    int[] array;
    int start;
    int end;
    public DequeUsingArray(int size) {
        array = new int[size];
        start=-1;
        end=-1;
    }

    public void insertFront(int num) throws Exception {
        if(start ==-1 && end ==-1) {
            start++;
            array[start] = num;
            end++;
        } else {
            if(start==0) {
                if(array.length-1 == end) {
                    throw new Exception("Deque filled");
                } else {
                    start = array.length-1;
                    array[start] = num;
                }
            } else {
                if(start-1 == end) {
                    throw new Exception("Deque filled");
                } else {
                    array[--start]= num;
                }
            }
        }
    }

    public void insertLast(int num) throws Exception {
        if(start ==-1 && end ==-1) {
            start++;
            array[start] = num;
            end++;
        } else {
            if(end==array.length-1) {
                if(start==0) {
                    throw new Exception("Deque filled");
                } else {
                    end=0;
                    array[end]=num;
                }
            } else {
                if(end+1==start) {
                    throw new Exception("Deque filled");
                } else {
                    array[++end] = num;
                }
            }
        }
    }

    public int removeFront() throws Exception {
        if(start==-1 || end==-1 || start-1 ==end) {
            throw new Exception("Empty Deque");
        }
        int num = array[start];
        if(start==end) {
            start=-1;
            end=-1;
        } else if(start==array.length-1) {
            start=0;
        } else {
            start++;
        }
        return num;
    }

    public int removeLast() throws Exception {
        if(start==-1 || end==-1 || start-1 ==end) {
            throw new Exception("Empty Deque");
        }
        int num = array[end];
        if(start==end) {
            start=-1;
            end=-1;
        } else if(end==0) {
            end = array.length-1;
        } else {
            end--;
        }
        return num;
    }

    public boolean isEmpty() {
        return (start==-1 && end==-1) || start-1 ==end || (start==array.length-1 && end==0);
    }

    public static void main(String[] args) throws Exception {
        DequeUsingArray deque = new DequeUsingArray(10);
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(0);
        System.out.println("IsEmpty : " + deque.isEmpty());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(1);
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(2);
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(3);
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());

        deque.insertFront(0);
        deque.insertFront(1);
        deque.insertFront(2);
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertFront(0);
        deque.insertFront(1);
        deque.insertFront(2);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(0);
        deque.insertLast(1);
        deque.insertLast(2);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println("IsEmpty : " + deque.isEmpty());
        deque.insertLast(0);
        deque.insertLast(1);
        deque.insertLast(2);
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println(deque.removeFront());
        System.out.println("IsEmpty : " + deque.isEmpty());
    }
}
