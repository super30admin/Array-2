// Time Complexity : O(n)
// Space Complexity : O(1)
// Total number of comparisons for even length of array = 3*(N/2) (Less than 2*(N-2))
// Total number of comparisons for even length of array = 3*(N/2) + 1 (Less than 2*(N-2))

public class MinMax {
    static public int[] minmaxValues(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //checking whether length of array is even or odd
            if(nums.length%2==0) {
                //even length
                for(int i=0; i<nums.length; i+=2) {
                    /* when length of array is even ~ comparison is between 1st-2nd element and min/max updating min/max, 
                    then 3rd-4th element and so on and min/max updating min/max and so on */
                    if(nums[i]>nums[i+1]) {
                        max = Math.max(nums[i], max);  
                        min = Math.min(nums[i+1],min);
                    } 
                    else {
                        max = Math.max(nums[i+1], max);  
                        min = Math.min(nums[i],min);
                    }       
                }
            }
            //odd length
            else {
                /* when length of array is even ~ comparison is between 1st-2nd element and min/max updating min/max, 
                    then 3rd-4th element and so on and min/max updating min/max and so on */
                for(int i=0; i<nums.length-1; i+=2) {
                    if(nums[i]>nums[i+1]) {
                        max = Math.max(nums[i], max);  
                        min = Math.min(nums[i+1],min);
                    } 
                    else {
                        max = Math.max(nums[i+1], max);  
                        min = Math.min(nums[i],min);
                    }       
                }
                /* Array length is odd, hence one element will be left for comparison */
                max = Math.max(nums[nums.length-1], max);
                min = Math.min(nums[nums.length-1], min);
            }
    return new int[] {max, min}; //returning min and max value
    }

    public static void main(String args[]) {
        int nums[] = {1000, 445, 11, 1, 330, 3000};
        int[] result = new int[2];
        result = minmaxValues(nums);
        System.out.println("Maximum Value = "+result[0]);
        System.out.println("Minimum Value = "+result[1]);
    }
}
