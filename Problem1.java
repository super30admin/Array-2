// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Maintain a Hashset to initially store the numbers that need to be present in the array
// Remove all the numbers that are present in the array
// We will be left with those that not absent in the array so add them to list and return

class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        //Start from 1 to n
        for(int i=1; i<=nums.length; i++){
            // add to hashset
            set.add(i);
        }
        // Iterate over the array
        for(int num: nums){
            // remove the number from set if present in array
            if(set.contains(num)){
                set.remove(num);
            }
        }
        // add all numbers left in set to list
        for(int num : set){
            output.add(num);
        }
        return output;
    }
}




// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// We will manipulate the array in such a way that we will be able to store what numbers are originally present in the array
// and we keep track of whether or not the index value is present in the array or not.
// We will maintain this simultaneously.


class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output= new ArrayList<>();
        //Iterate over array
        for(int num : nums){
            int key= Math.abs(num)-1;
            if(nums[key]>0){
                nums[key]*=-1;
            }
        }
        for(int i=0; i<nums.length; i++){
            int num= nums[i];
            // If the number is +ve it means we have not encountered the index place value of it it in the entire array
            // so add to list
            if(num>0){
                output.add(i+1);
            }
        }
        return output;
    }
}