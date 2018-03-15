
public class LargestContinuousSum {

    public int largestContinuousSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prevMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(prevMax < 0) {
                prevMax = nums[i];
            } else {
                prevMax = prevMax+nums[i];
            }
            if(prevMax>max) {
                max = prevMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestContinuousSum l = new LargestContinuousSum();
        System.out.println(l.largestContinuousSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}
