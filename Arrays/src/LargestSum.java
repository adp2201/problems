import java.util.Arrays;

/**
 * Created by amolp on 1/15/18.
 */
public class LargestSum {

    public static int largestSumSubarray(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i< array.length; i++) {
            int sumSubarray = 0;
            int maxSumSubarray = Integer.MIN_VALUE;
            for (int j=i; j<array.length; j++) {
                sumSubarray+=array[j];
                if(sumSubarray>maxSumSubarray) {
                    maxSumSubarray = sumSubarray;
                }
            }
            if(maxSumSubarray > maxSum) {
                maxSum = maxSumSubarray;
            }
        }
        return maxSum;
    }

    public static void main(String [] args) {
        int [] array = new int[] {1,-2,-3,4,-1,-2,5};
        System.out.print(largestSumSubarray(array));
    }
}
