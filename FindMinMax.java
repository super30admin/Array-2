// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we will loop through the array with the elements in pairs
//we will have two variables keeping track of max/min after every pair

public class FindMinMax {
    public static int[] findMinMax(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //loops every other
        for(int i = 0; i < nums.length; i+=2){
            if(i+1 < nums.length){
                max = Math.max(max, Math.max(nums[i], nums[i+1]));
                min = Math.min(min, Math.min(nums[i], nums[i+1]));
            }
        }

        //if odd length for nums
        if(nums.length % 2 != 0){
            max = Math.max(max, nums[nums.length - 1]);
            min = Math.min(min, nums[nums.length - 1]);
        }

        System.out.println(min);
        System.out.println(max);
        return new int[]{min,max};
    }
    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        System.out.println(findMinMax(arr));
    }
}