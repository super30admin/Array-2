/***
 * TC - O(n), SC - O(1)
 */
public class FindMinAndMaxInArr {

    public static int[] findMinAndMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        //Compare in pairs
        for(int i =0; i <n-1;) {
            if(nums[i+1] > nums[i]) {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }

            else {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }

            i=i+2;
        }

        if(n%2 != 0) {
            max = Math.max(max, nums[n-1]);
            min = Math.min(min, nums[n-1]);
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 20, 3, 4, 8, 0, 2, 10};
        int[] result = findMinAndMax(nums);

        System.out.println("Max= " + result[0] + ", Min= " + result[1]);
    }
}
