
public class Fibonacci {
    public int findFibonacciBasic(int n) {
        if(n==1 || n==2) {
            return 1;
        }
        return findFibonacciBasic(n-1) + findFibonacciBasic(n-2);
    }

    public int findFibonacciDP(int n) {
        int[] fibs = new int[n+1];
        return findFibonacciDP(n, fibs);
    }

    public int findFibonacciDP(int n, int[] fibs) {
        if(n==1 || n==2) {
            fibs[n] = 1;
            return 1;
        } else {
            fibs[n] = findFibonacciDP(n-1, fibs) + findFibonacciDP(n-2, fibs);
        }
        return fibs[n];
    }

    public int findFibonacciDP2(int n) {
        int[] fibs = new int[n+1];
        for(int i=1; i<=n; i++) {
            if(i==1 || i==2) {
                fibs[i] =1;
            } else {
                fibs[i] = fibs[i-1] + fibs[i-2];
            }
        }
        return fibs[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        long t1 = System.currentTimeMillis();
        System.out.println(f.findFibonacciBasic(45));
        long t2 = System.currentTimeMillis();
        System.out.println(f.findFibonacciDP(45));
        long t3 = System.currentTimeMillis();
        System.out.println(f.findFibonacciDP2(45));
        long t4 = System.currentTimeMillis();
        System.out.println("findFibonacciBasic : " + (t2-t1) + ", findFibonacciDP : " + (t3-t2) + ", findFibonacciDP2 : " + (t4-t3));
    }
}
