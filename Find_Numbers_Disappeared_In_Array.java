//Approach - State Change
// The value from the nums array will be subtracted with 1 and the result value will be used as an index and the value in that index will be changed to a negtaive number
// Finally the index of the array value with the positive values is added to 1, and put into result list.
//Time Complexity - O(N)
//Space Complexity - O(1) - excluding the result List<Integer>

class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {

    if(nums == null || nums.length == 0){
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    for(int i=0; i<nums.length; i++){

      int index = Math.abs(nums[i])-1;

      if(nums[index] > 0){
        nums[index] = nums[index]*-1;
      }
    }

    for(int i=0; i<nums.length; i++){
      if(nums[i] > 0){
        result.add(i+1);
      }else{
        nums[i] = nums[i]*-1;
      }
    }
    return result;
  }
}