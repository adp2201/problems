import java.util.Arrays;

/**
 * Created by amolp on 1/14/18.
 */
public class Rotation {
    public static int[] rotateBackward(int[] array, int count) {
        int [] dupe = new int[array.length];
        for(int i=0; i<array.length; i++) {
            dupe[i] = array[(i+count) % array.length];
        }
        return dupe;
    }

    public static int[] ratateForwardSameArray(int array[], int count) {
        int j=0,k =0;
        int total =0;
        for(int start = 0; total < array.length; start++) {
            j=start;
            int previous = array[j];
            do {
                int temp = array[(j+count)%array.length];
                array[(j+count)%array.length] = previous;
                previous = temp;
                j=(j+count)%array.length;
                total++;
            }while(j!=start);
        }
        return array;
    }

    public static int[] rotateForward(int[] array, int count) {
        int [] dupe = new int[array.length];
        for(int i=0; i<array.length; i++) {
            dupe[i] = array[(i-count+array.length) % array.length];
        }
        return dupe;
    }

    public static int[] rotateForwardByReverse(int[] array, int count) {
        reverse(array, 0, array.length-1);
        reverse(array, 0, count-1);
        reverse(array, count, array.length-1);
        return array;
    }

    public static int[] rotateBackwardByReverse(int[] array, int count) {
        reverse(array, 0, array.length-1);
        reverse(array, 0, array.length-(count+1));
        reverse(array, array.length-count, array.length-1);
        return array;
    }

    public static int[] reverse(int[] array, int start, int end) {
        for( ; start<end; start++,end--) {
            int temp = array[start];
            array[start]=array[end];
            array[end] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] original = new int[]{0,1,2,3,4,5,6};
        System.out.print(Arrays.toString(rotateForward(original, 2)));
        System.out.print(Arrays.toString(rotateBackward(original, 2)));
        System.out.print(Arrays.toString(ratateForwardSameArray(original, 2)));
        original = new int[]{0,1,2,3,4,5,6};
        System.out.print(Arrays.toString(reverse(original, 0, 6)));
        original = new int[]{0,1,2,3,4,5,6};
        System.out.print(Arrays.toString(rotateForwardByReverse(original,2)));
        original = new int[]{0,1,2,3,4,5,6};
        System.out.print(Arrays.toString(rotateBackwardByReverse(original,2)));
    }
}
