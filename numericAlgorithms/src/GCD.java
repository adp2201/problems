import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCD {
    public GCD() {
    }

    private static int gcd(int a, int b) {
        while(b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return a;
    }

    private static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        int lcm = ( a / gcd ) * b;
        return lcm;
    }

    private static List<Integer> primeFactors(int a) {
        List<Integer> factors = new ArrayList<>();
        while(a % 2 == 0) {
            factors.add(2);
            a = a/2;
        }
        int factor = 3;
        double sqrt = Math.sqrt(a);
        while(factor <= sqrt) {
            while (a % factor == 0) {
                factors.add(factor);
                a = a/factor;
                sqrt = Math.sqrt(a);
            }
            factor += 2;
        }
        if(a > 1) {
            factors.add(a);
        }
        return factors;
    }

    private static List<Integer> primeNumber(int max) {
        double sqrtOfMax = Math.sqrt(max);
        Boolean[] isPrime = new Boolean[max+1];
        Arrays.fill(isPrime, Boolean.TRUE);
        int even = 2;
        isPrime[even] = true;
        even *= even;
        while (even <= max) {
            isPrime[even] = false;
            even += 2;
        }
        int number = 3;
        while(number <= sqrtOfMax) {
            if(isPrime[number]) {
                int nonPrime = number*number;
                while(nonPrime <= max) {
                    isPrime[nonPrime] = false;
                    nonPrime += (2* number);
                }
            }
            number += 2;
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i < max+1; i++) {
            if(isPrime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


    /**
     * TODO - 1. Print first n prime numbers.
     * TODO - 2. Find LCM without GCD.
     * TODO - 3. Find square root.
     * @param args
     */

    public static void main(String[] args) {
        int a = 98;
        int b = 56;
        System.out.println("GCD of " + a  + " and " + b + " is " + gcd(98, 56));
        System.out.println("LCM of " + a  + " and " + b + " is " + lcm(98, 56));
        int num = 2100;
        List<Integer> primeFactors = primeFactors(num);
        System.out.println("Prime factors of " + num + " are :");
        for (int factor : primeFactors) {
            System.out.println(factor);
        }
        int max = 100;
        List<Integer> primeNumbers = primeNumber(max);
        System.out.println("Prime numbers smaller than " + max + " are : ");
        for(int number : primeNumbers) {
            System.out.println(number);
        }


    }
}
