
public class TwoStacks {
    int[] array;
    int top1;
    int top2;

    public TwoStacks(int size) {
        array = new int[size];
        top1 = -1;
        top2 = size;
    }

    public int pop1() {
        int index = top1;
        top1--;
        return array[index];
    }

    public int pop2() {
        int index = top2;
        top2++;
        return array[index];
    }

    public int peek1() {
        return array[top1];
    }

    public int peek2() {
        return array[top2];
    }

    public void push1(int num) throws Exception {
        if(top1+1<top2) {
            array[++top1] = num;
        } else {
            throw new Exception();
        }
    }

    public void push2(int num) throws Exception {
        if(top2-1>top1) {
            array[--top2] = num;
        } else {
            throw new Exception();
        }
    }

    public boolean isEmpty1() {
        return top1==-1;
    }

    public boolean isEmpty2() {
        return top2==array.length;
    }

    public int search1(int num) {
        for(int i=top1; i>=0; i--) {
            if(array[top1] == num) {
                return top1-i;
            }
        }
        return -1;
    }

    public int search2(int num) {
        for(int i=top2; i < array.length; i++) {
            if(array[top2] == num) {
                return i=top2;
            }
        }
        return -1;
    }

    public void print1() {
        System.out.println("Stack 1 : ");
        for(int i=top1; i>=0; i--) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }

    public void print2() {
        System.out.println("Stack 2 : ");
        for(int i=top2; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        TwoStacks stack = new TwoStacks(10);
        stack.print1();
        stack.print2();
        System.out.println(stack.isEmpty1());
        System.out.println(stack.isEmpty2());
        stack.push1(0);
        stack.print1();
        stack.push2(5);
        stack.print2();
        stack.push1(10);
        System.out.println("Index of 10 is " + stack.search1(10));
        stack.print1();
        stack.push2(15);
        System.out.println("Index of 10 is " + stack.search2(10));
        stack.print2();
        stack.push1(20);
        stack.push1(25);
        stack.push1(25);
        stack.push1(25);
        stack.push1(25);
        stack.push2(35);
        stack.print1();
        stack.print2();

//        System.out.println("Index of 10 is " + stack.search(10));
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.search(10));
    }

}
