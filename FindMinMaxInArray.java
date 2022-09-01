// Time Complexity - O(n)
// Space Complexity - O(1)

// solution using 1.5n comparison instead of 2n

public class FindMinMaxInArray {
    public static void findMinMax(int[] nums){
        int max =0, min = 0;
        for (int i=0; i<nums.length - 1 ;i++){
            if( nums[i] > nums[i+1]){
                max = Math.max(max,nums[i]);
                min = Math.min(min,nums[i+1]);
            }
            else{
                max = Math.max(max,nums[i+1]);
                min = Math.min(min,nums[i]);
            }
        }
        System.out.println("Min : " + min + " Max :" + max);
    }

    public static void main(String[] args){
        int[] nums = new int[] {1,8,4,6,2,0};
        findMinMax(nums);
    }

}
