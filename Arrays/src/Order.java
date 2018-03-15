import java.util.*;

/**
 * Created by amolp on 1/15/18.
 */
public class Order {

    public static int kthLargest(int[] array, int k) {
        List<Integer> set = new ArrayList<>();
        int kthLargest = Integer.MIN_VALUE;
        for(int i=0; i<k; i++) {
            int ithLargest = Integer.MIN_VALUE;
            for(int j=0; j<array.length; j++) {
                if(!set.contains(array[j]) && array[j] > ithLargest) {
                    ithLargest = array[j];
                }
            }
            set.add(ithLargest);
            kthLargest = ithLargest;
        }
        return kthLargest;
    }

    public static int kthLargestBySorting(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }

    public static int findKthLargest(int[] array, int k) {
        int[] largest = new int[k];
        for(int i=0; i< k; i++) {
            largest[i] = array[i];
        }
        for(int j=k; j<array.length; j++) {
            int minIndex = 0;
            for(int i=0; i<k; i++) {
                if(largest[i]<largest[minIndex]) {
                    minIndex = i;
                }
            }
            if(array[j] > largest[minIndex]) {
                largest[minIndex] = array[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            if(largest[i]< min) {
                min = largest[i];
            }
        }
        return min;
    }

    public static void main(String [] args) {
        System.out.print(findKthLargest(new int[]{2,1}, 2));
    }
}
