// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;				// total number of elements and max value in the array
        boolean[] sout = new boolean[len+1];	// create a boolean of index one greater than nums
        List<Integer> temp = new ArrayList<>();	// output list
        sout[0] = false;					// we dont need 0th index
        
        for(int i = 0; i < len; i++){		// find the value and change the boolean state to true in the boolean array as per the value index
            if(sout[nums[i]] == false){
                sout[nums[i]] = true;
            }
        }
        
        for(int i = 1; i <= len; i++){		// traverse through the boolean array, find the all the indexes with false until the max value
            if(sout[i] == false){
                temp.add(i);				// add the indexes to the out array
            }
        }
        
        return temp;						// return the indexes array
    }
}