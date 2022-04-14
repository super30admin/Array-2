// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
	// 2) We start with 0 index, if value is positive, change it to negative, then it means we never visited that value yet
	// 3) Take the positive value, subtract -1, go the index of result.
	// 4) At new index, if value is +ve, then change it to -ve. Again subtract -1 from +ve value
	// 5) Again go index, until u reach back to 0 index
	// 6) Then iterate over array again, and check positive value. Takes their index, add +1 to index, those are missing numbers
	// 7) Because values are btween 1 to n, so doing -1 , will always remain within array.


 public IList<int> FindDisappearedNumbers(int[] nums) {
        
    if(nums == null || nums.Length == 0)
        return new List<int>();
    
    List<int> result = new List<int>();
    
    //all values are between 1 to n, so that running loop 0 to n-1 should be able to traverse 
    //all elements ecept missing
    for(int i = 0; i < nums.Length; i++)
    {
        int index  = Math.Abs(nums[i]) - 1;

        //inspace changing values from +ve to -ve
        //so that we know we already visited that number
        if(nums[index] > 0)
            nums[index] = nums[index] * -1;
                    
    }
    
    //iterate over once more
    //+ve numbers are one which are not visted yet, index+1 is the missing number
    for(int i = 0; i < nums.Length; i++)
    {
        if(nums[i] > 0)
            result.Add(i+1);
        else
            nums[i] = nums[i] * -1;
    }
    
    return result;
}