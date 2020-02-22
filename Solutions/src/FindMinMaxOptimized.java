// Time Complexity :Could'nt uderstand the time complexity calculated in class(3N/2 -2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No
public class FindMinMaxOptimized {
    private static  int[] computeMinMax(int[] nums){
        int max = 0, min = 0 , index = 0;
        if(nums.length % 2 ==1){
            max = nums[0];
            min = nums[1];
            index = 1;
        }
        else{
            max = nums[0];
            min = nums[1];
            index = 2;
        }

        for(int i = index; i < nums.length-1; i+=2){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
            else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        return new int[] {min,max};
    }

    public static void main(String[] args) {
        int[] nums = {2,8,6,2,11,5,70};
        int[] op = computeMinMax(nums);
        System.out.println(op[0]);
        System.out.println(op[1]);
    }
}

