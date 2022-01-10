class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>(); // if the nums array is null or the length of the nums array is 0, we simply return the new arraylist.
        List<Integer> result = new ArrayList<>(); // we create a new arraylist with name result;
        for(int i = 0; i < nums.length; i++) { // we are iterating through the array
            int index = Math.abs(nums[i]) - 1; // we create an integer variable called as index which stores the absolute value of the current value and find the index we do - 1 to it.
            if(nums[index] > 0) { // if the index value in that nums array is greater than 0
                nums[index] = -1 * nums[index]; // we change it to a negative value;

            }
        }
        for(int i = 0; i < nums.length; i++) { // we go through the array again.
            if(nums[i] < 0) { // if the element in that index is 0
                nums[i] = -1 * nums[i]; // we convert it back to positive
            }
            else { // if the element is +ve
                result.add(i + 1); // we add that element to the result array.
            }
        }
        return result; // in the end, we return the result.
    }
}
// tc and sc - O(n) and O(1)