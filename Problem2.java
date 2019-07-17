// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : "Cannot find this on leetcode"
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. If length is 1 then return it as both min and max , else take min,max as minimum and maximum of first two elements
// 2. Traverse from 3rd element and compare with min and max
public class MinMax {
    public static int[] minMax(int[] nums){
        if(nums.length==0)
            return new int[]{-1,-1};
        if(nums.length == 1)
            return new int[]{nums[0],nums[0]};
        int min = Math.min(nums[0],nums[1]);
        int max = Math.max(nums[0],nums[1]);
        for(int i =2;i<nums.length;i++){
            if(nums[i]<min)
                min = nums[i];
            else if(nums[i]>max)
                max = nums[i];
        }
        return new int[]{min,max};
    }
    public static void main(String[] args) {
        int [] nums = {5,4,3,2,1};
        int [] result = minMax(nums);
        System.out.println("Min : "+result[0]);
        System.out.println("Max : "+result[1]);
    }
}
