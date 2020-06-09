// Time Complexity : O(n) where n is size of array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<Integer>(); //to store missing numbers
        HashSet<Integer> numbers = new HashSet<Integer>(); // To store numbers
        for(int i : nums){
            numbers.add(i); // takes care of duplicate values.
        }
        
        for(int i = 1; i <=nums.length; i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}

// with no extra space O(1)

//public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> missingNumbers = new ArrayList<Integer>();
//         int val = 0;
//         for(int i=0;i<nums.length;i++){
//             val = Math.abs(nums[i]) - 1;
//             if(nums[val] < 0){
//                 continue;
//             }
//             nums[val] = -nums[val];
//         }
//         for(int i=0;i<nums.length;i++){
//             if(nums[i] >= 0){
//                 missingNumbers.add(i+1);
//             }
//         }
//         return missingNumbers;
//     }