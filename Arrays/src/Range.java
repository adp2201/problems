import java.util.Arrays;

/**
 * Created by amolp on 1/15/18.
 */
public class Range {

    public static int[] subarrayMax(int [] array, int[][] input) {
        int [] output = new int[input.length];
        int [][] subarrayMax = new int[array.length][array.length];

        for(int i = 0; i< array.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < array.length; j++) {
                if(array[j] > max) {
                    max = array[j];
                }
                subarrayMax[i][j] = max;
            }
        }

        for(int i=0; i< subarrayMax.length; i++) {
            System.out.println(Arrays.toString(subarrayMax[i]));
        }

        for (int i=0; i< input.length; i++) {
            output[i] = subarrayMax[input[i][0]][input[i][1]];
        }
        return output;
    }

    public static int[] subarrayMax2(int[] array, int[][] input) {
        int [] output = new int[input.length];
        int rootN = (int)Math.sqrt(array.length);
        int [] maxRootSubarray = new int[(array.length/rootN)+1];
        int j = rootN-1;
        int max = Integer.MIN_VALUE;
        int k = 0;
        for(int i=0; i< array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(i==j) {
                maxRootSubarray[k] = max;
                k++;
                j+=rootN;
            }
        }

        for(int i = 0; i < input.length; i++) {
            int start = input[i][0];
            int end = input[i][1];
            int leftCornerIndex = -1, rightCornerIndex = 0;
            int l = -1;
            while (l<start) {
                l+=rootN;
                leftCornerIndex++;
            }
            rightCornerIndex = leftCornerIndex;
            while (l+rootN<end) {
                l+=rootN;
                rightCornerIndex++;
            }
            int maxVal = Integer.MIN_VALUE;
            if(rightCornerIndex==leftCornerIndex) {
                for(int m = start; m<=end; m++) {
                    if(array[m] > maxVal) {
                        maxVal = array[m];
                    }
                }
            } else {
                for(int m = leftCornerIndex; m <= rightCornerIndex; m++) {
                    if(maxRootSubarray[m] > maxVal) {
                        maxVal = maxRootSubarray[m];
                    }
                }
                for(int m = start; m < rootN*leftCornerIndex; m++) {
                    if(array[m] > maxVal) {
                        maxVal = array[m];
                    }
                }
                for(int m = l; m<=end; m++) {
                    if(array[m] > maxVal) {
                        maxVal = array[m];
                    }
                }
            }
            output[i] = maxVal;
        }
        return output;
    }

    public static void main(String [] args) {
        int[] array = { 7, 2, 3, 0, 5, 10, 3 };
        int[][] input = new int[][]{{0,5}, {4,4}, {5,6}, {2,5}};
        System.out.println(Arrays.toString(subarrayMax(array, input)));
        System.out.println(Arrays.toString(subarrayMax2(array, input)));

    }

}
