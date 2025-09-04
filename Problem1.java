// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
We change the state of element by first taking the absolute value of it and calculating its index we make the element at its
index as negative indicating that element has been visited
Collect the indices of the element that are positive which would give us the result
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        // get the index of each element 
        for (int i = 0; i < n ;i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * -1; //change the state of the element to minus
            }
        }

        //Get the indices of elements that are positive
        for(int i = 0; i< n; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;  
    }
}
