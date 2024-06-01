/*
    LC - 448. Find All Numbers Disappeared in an Array
    TC - O(n)
    SC - O(1)
    Approach - 
        Logic is to mark the existing element as negative element.

        Subtract -1 from the element (take absolute value of the element)
        and go the index (which is subtracted value) to make the element as negative.

        Traverse the element and if the element is positive, add that element in the result list.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length==0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}