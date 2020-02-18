// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


/*
Approach-1:
=========
1. Take temporary array and as soon as a number is found, update exact index with -1
2. Now, iterate through temp array and check if any index is not -1
3. Whichever indices aren't -1 couldn't be found in the array
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length];
        
        List<Integer> result = new ArrayList<>();
        //Update found number index to -1
        for(int i = 0; i < nums.length; i++) {
            temp[nums[i]-1] = -1;
        }
        // If not -1, then that number was not found, so add it to arraylist
        for(int i = 0; i < nums.length; i++) {
            if(temp[i] != -1) 
                result.add(i+1);
        }
        return result;
    }
}

/*
Approach-2:
===========
1. Similar to above approach except that instead of using additional space, negate the value which is stored in the array at
that index.
2. If at an index, value is positive, that means the value doesn't exist in the array
*/



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if( nums == null || nums.length == 0) return result;
        // update positive values to negative when the number is found
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val-1] > 0)
                nums[val-1] = -(nums[val-1]);
        }
        // check whichever index is positive and add it to list
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}