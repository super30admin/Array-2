import java.util.*;

class Sample {

    
    // Time Complexity : O(N) where N is size of the array
    // Space Complexity : O(1) 
    // Any problem you faced while coding this : No

    // Problem 1
    /**
     * 1. Since all the numbers are present in sequence, mark the element nums[nums[i] - 1] as negative.
     * 2. Then traverse through the array again and the numbers which are positive, their (index + 1) is missing.
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }
        
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] > 0)
                list.add(i+1);
        }
        
        return list;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Any problem you faced while coding this : number of comparisons are not less than 2*(N-2)

    // Problem 2

    public void findMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        System.out.println("Minimum is :" + min);
        System.out.println("Maximum is :" + max);
    }

}

