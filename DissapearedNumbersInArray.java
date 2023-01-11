// Time Complexity: O(n)
// Space complexity: O(1)

// Approach: 
// Iterate through the array
// For example if the current element is 4, get its corresponding index i.e. 4-1 which is 3. Because in an ordered list starting from 0, 
// 4's index would be 3.
// Go to that index, for example idx 3, and make its element negative.
// If an element occurs more than once in the array, the value at its corresponding index might already be negative, so we skip it.
// Iterate through the array again and check if a number which wasnt converted to negative, meaning it was unchanged.
// We do i+1 for that element, this i+1 would be the missing number. Add this to the resultant array. 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            
            int idx=Math.abs(nums[i])-1; //get the corresponding index of that value
            
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if (nums[i]>0){ //if any number wasnt converted to negative
                result.add(i+1); //Add the value corresponding to its index
            } 
            else {
                nums[i]*=-1; //to revert back to positive number in original array, but not required
            }
        
        }
        
        return result;
    }
}