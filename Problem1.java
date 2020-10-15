// Time Complexity : O(n)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes its not easy to get intuitively


// Your code here along with comments explaining your approach
class Solution {
   /** We traverse through the array and for each 'element' we make the number
   at array[element-1] negative if its not already negative, this way we dont overwrite
   any elements and the only numbers that remain positive have index+1 as those numbers
   that were never in the array **/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
           int curr = Math.abs(nums[i])-1;
            if(nums[curr]>0)
            nums[curr]=0-nums[curr];

        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                output.add(j+1);
            }
        }
        return output;
    }
}