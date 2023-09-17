class Solution {
    // Time Complexity : 2*O(n) -> O(n)(Asymptotically) where n is the number of elements in nums array 
    // Space Complexity: O(1) constant space 
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // If nums array is null return empty list.
        if(nums==null || nums.length==0)
        {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            // We are subtracting 1 from the value as the values start from 1 to n and index go from 0 to n.
            int index = Math.abs(nums[i])-1; // Subtract 1 element at index i
            // at specific index go and make the element as negative indicating that we have traversed this element.
            if(nums[index]>0)
            {
                nums[index]=-1*nums[index];
            }     
        }

        for(int i=0;i<nums.length;i++)
        {
            // Wherever we see positive values that indicates that the specifc index is not traversed and value index+1 is missing from the array.
            // Here we are doing index + 1 as the elements are from 1 to n and index are from 0 to n.
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }

        return result;
        
    }
}
