import java.util.Arrays;

/**
 * Created by amolp on 1/17/18.
 */
public class MaxProfit {

    public static int maxProfit(int[] rates) {
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i < rates.length; i++) {
            int profitOnIth = Integer.MIN_VALUE;
            for(int j=i; j< rates.length; j++) {
                if(rates[j] - rates[i] > profitOnIth) {
                    profitOnIth = rates[j] - rates[i];
                }
            }
            if(profitOnIth > maxProfit) {
                maxProfit = profitOnIth;
            }
        }
        return maxProfit;
    }

    public static int maxProfitTwice(int[] rates) {
        int maxProfit = Integer.MIN_VALUE;
        int[][] maxProfitsPerPosition = new int[rates.length][2];
        for(int i=0; i< rates.length; i++) {
            int profitOnIth = Integer.MIN_VALUE;
            int profitIndex = 0;
            for(int j=i; j<rates.length; j++) {
                if(rates[j] - rates[i] > profitOnIth) {
                    profitOnIth = rates[j] - rates[i];
                    profitIndex = j;
                }
            }
            maxProfitsPerPosition[i][0] = profitIndex;
            maxProfitsPerPosition[i][1] = profitOnIth<0 ? 0 : profitOnIth;
        }

        for(int i=0; i< maxProfitsPerPosition.length; i++) {
            int a = maxProfitsPerPosition[i][0];
            int profitAfterA = a+1 >= maxProfitsPerPosition.length ? 0 : maxProfitsPerPosition[a+1][1];
            if(maxProfitsPerPosition[i][1] + profitAfterA > maxProfit) {
                maxProfit = maxProfitsPerPosition[i][1] + profitAfterA;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.print(maxProfitTwice(new int[]{1,4,3,12}));
    }
}
