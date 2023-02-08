/*
Find max and min in an array using 2(n-2) comparisons
approach: compare elements in pairs

time: O(n)
space: O(1)
 */
public class Problem2 {
    static void findMaxAndMin(int[] nums) {
        int max = nums[0], min=nums[0];

        for (int i=0;i<nums.length;i =i+2){
            if(nums[i]>nums[i+1]) {
                if (nums[i]>max) max = nums[i];
                if (nums[i+1]<min) min = nums[i+1];
            }
            else {
                if (nums[i]<min) min = nums[i];
                if (nums[i+1]>max) max = nums[i+1];
            }
        }

        System.out.println("min and max are "+ min +" and "+max);
    }

    public static void main(String []args) {
        findMaxAndMin(new int[]{4,3,2,7,8,2,3,1});
    }
}
