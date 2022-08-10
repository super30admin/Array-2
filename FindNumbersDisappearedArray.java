// Solution1 : Maintaining an auxilary array to keep track of elements present

// Time Complexity : O(2n) = O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// In this solution, we maintain an auxilary array to track the elements present in the input array
// We put every element at its correct index in the auxilary array
// At the end, we check which elements are not present in the auxilary array.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
    
        int[] temp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            
            int currNum = nums[i];
            
            temp[currNum - 1] = currNum;
        }
        
        for (int i=0;i<temp.length;i++) {
            if(temp[i] == 0) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}

// Solution 2 : In-place Modification the input array to mark the presence of an element

// Time Complexity : O(2n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
    
        // int[] temp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            
            int currNum = Math.abs(nums[i]);
            
            // mark the number negative at the index =. currNum -1
            
            if (nums[currNum - 1] > 0)
                nums[currNum - 1] *= -1;
        }
        
        for (int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}