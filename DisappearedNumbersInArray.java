// Approach: Iterate through i/p array and get the index of the num and go to the number at that index and mark it as negative
// Now go through the marked array and if any number found is negative then convert to positive to retrieve the I/P array and the found positive number get index of it and index+1 is the missing number
// Time: O(n) + O(n)
// Space: O(1) // result array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }

        for(int i=0;i<nums.length;i++){
            // retrieve the positive number
            if(nums[i]<0){
                nums[i] *= -1;
            } else{
                result.add(i+1);
            }
        }

        return result;
        
    }
}