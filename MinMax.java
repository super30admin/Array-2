// Time Complexity : O(n)
// Space Complexity : O(1)
// Comparisons : 3n/2
// Did this code successfully run on Leetcode :NA
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

public class MinMax {
     public List<Integer> getMinMax(int[] nums)
     {
       int n = nums.length;
       int i = 0;
       int min = 0;
       int max =0;
       List<Integer> result = new ArrayList<>();
        if(nums.length !=0 && nums!=null)
        {
            min = nums[0];
            max = nums[0];
        }
        while(i<n-1)
        {
            if(nums[i] > nums[i+1])
            {
                if(nums[i] > max)
                {
                    max = nums[i];
                }
                if(nums[i+1] < min)
                {
                    min = nums[i+1];
                }
            }
            else
            {
                 if(nums[i+1] > max)
                {
                    max = nums[i+1];
                }
                if(nums[i]< min)
                {
                    min = nums[i];
                }
            }

            i = i+2;
            if(i+1 == n)
            {
                max = Math.max(max, nums[i]);
                min = Math.min(min,nums[i]);
            }
           
        }
        result.add(min);
        result.add(max);
        return result;
     }

     public static void main(String args[]) {
        int arr[] = {1000, 11, 0, 330, 3000,5000};
        MinMax m = new MinMax();
        System.out.println(m.getMinMax(arr).toString());

 
    }
}
