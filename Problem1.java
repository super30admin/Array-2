//Problem - LeetCode 448 Find All Numbers Disappeared in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not able to come up with this logic on my own

// Your code here along with comments explaining your approach
import java.util.*;

//Approach - mark the numbers which are already there as negative. So in the second traversal we can iddentify the non negative numbers and their index + 1 should be the missing number

public class Problem1 {
    public List<Integer> findDisappearedNumber(int [] nums){
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        //first for the given number nums[i] -- see what should be its actual index
        //for e.g. nums[i] = 4 --> its index should be 3; So mark nums[3] as negative (*-1)

        for(int i = 0; i < n; i++){
                int idx = Math.abs(nums[i]) - 1;
                if(nums[idx] < 0) continue; //number already marked as negative
                else nums[idx] *= -1;
        }

        // In second traversal - whatever are the numbers are non negative, for them add their idx + 1 into the result
        
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) nums[i] *= -1; // to keep original array as intact
            else result.add(i+1); //number at that idx is non negative so idx + 1 would be missing so add it in the list.
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1 demo = new Problem1();
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(demo.findDisappearedNumber(nums)); 
    }
}
