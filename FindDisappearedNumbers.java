// Time Complexity : O(n) n:Array length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//Traversing through the array will be considering that element as index and will make the value present in that index negative confirming we have that element in the array and also not modifying the value present in that index so at last the indexes which doesn't contain negative elements are not present in the array.


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                 nums[index] = -nums[index];
        }
        for(int  i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                arr.add(i+1);
            }
        }
        return arr;   
    }
}
