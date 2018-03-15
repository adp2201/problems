import java.util.Arrays;

/**
 * Created by amolp on 1/18/18.
 */
public class Rotate {

    public static int[][] rotate90(int[][] A) {
        int n = A.length;
        if(n>0) {
            if(A[0].length>n) {
                n = A[0].length;

            }
        }
        for(int i=0; i<n-1-i; i++) {
            for(int j=i; j<n-1-i; j++) {
                int temp = A[n-1-j][i];
                A[n-1-j][i] = A[n-1-i][n-1-j];
                A[n-1-i][n-1-j] = A[j][n-1-i];
                A[j][n-1-i] = A[i][j];
                A[i][j] = temp;
            }
        }
        return A;
    }

    public static void main(String [] args) {
        int [][] A = new int[][]{{1,2,3,4,5,26},{6,7,8,9,10,27},{11,12,13,14,15,28}, {16,17,18,19,20,29}, {21,22,23,24,25,30},{31,32,33,34,35,36}};
        for(int i=0;i<A.length;i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        rotate90(A);
        System.out.println("ROTATED!");
        for(int i=0;i<A.length;i++) {
            System.out.println(Arrays.toString(A[i]));
        }
    }
}
