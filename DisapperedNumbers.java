/**Leetcode Question - 448 - Find all disappered numbers in a array */
/**Algorithm - State change
 * Traverse through the nums array and for every number you see, change the state of the number on nums[i] -1 index 
 * traverse through the array again. Places where you find positive numbers, add 1 to the index and add them to the resultant array. They were not present in the given array.
 */
/**TC- O(N)
 * SC -O(1)
 */
public class DisapperedNumbers {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i =0; i<nums.length; i++){
                int index = Math.abs(nums[i]);
                if(nums[index-1]>0){
                    nums[index-1] = nums[index -1] * -1;
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for(int i =0; i<nums.length; i++){
                if(nums[i]>0){
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}
