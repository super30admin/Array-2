//Problem : 448 . Find all numbers disappeared in Array
//Solved successfully on leetcode and faced no issues
//Time complexity : O(n) + O(n) = O(2n) ~= O(n)
//Space complexity : O(1)
// Approach:
// Make index = element - 1 as negative suppose if element is 4 mark 4-1 = 3rd index as negative
// Traverse the array again to find indices with positive values, which means missing numbers.
// Add those index + 1 values to the output array


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>output = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1; //access the index of a current number
            if(nums[index]>0){
                nums[index] = -nums[index]; //marking indices as negative
            }
        }
        //add the postive indices to the output array
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                output.add(i+1);
            }
        }
        return output;
        
    }
}