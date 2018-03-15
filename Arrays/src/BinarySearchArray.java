
public class BinarySearchArray {
    public int[] searchRange(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        int range[] = {-1,-1};
        int targetIndex = -1;
        if(nums==null || nums.length==0) {
            return range;
        }
        int mid = (start+end)/2;
        while(start<=end) {
            mid = (start+end)/2;
            if(nums[mid]>target) {
                end = mid-1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                break;
            }
        }
        targetIndex = mid;
        if(targetIndex==-1 || nums[targetIndex]!=target) {
            return range;
        }
        start=0;
        end=targetIndex;
        mid = (start+end)/2;
        while(start<=end) {
            mid = (start+end)/2;
            if(nums[mid]<target && mid<nums.length-1 && nums[mid+1]<target) {
                start = mid+1;
            } else if(nums[mid]==target) {
                end = mid-1;
            } else {
                break;
            }
        }
        if(nums[mid]<target && mid<nums.length-1 && nums[mid+1]==target) {
            range[0]=mid+1;
        } else {
            range[0]=0;
        }
        start=targetIndex;
        end = nums.length-1;
        while(start<=end) {
            mid = (start+end)/2;
            if(nums[mid]>target && mid>0 && nums[mid-1]>target) {
                end = mid-1;
            } else if(nums[mid]==target) {
                start = mid+1;
            } else {
                break;
            }
        }
        if(nums[mid]>target && mid>0 && nums[mid-1]==target) {
            range[1]=mid-1;
        } else {
            range[1]=nums.length-1;
        }
        return range;
    }

    public static void main(String[] args) {
        BinarySearchArray a = new BinarySearchArray();
        int[] range = a.searchRange(new int[]{1,4}, 4);
        System.out.println(range[0] + " : " + range[1]);
    }
}
