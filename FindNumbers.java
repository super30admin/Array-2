// Time Complexity : O(n) where 'n' is the length of the nums.
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Any problem you faced while coding this : No

// Explaination: For each value in the array mark its presence by making the number negative at that place in array
//eg. if you have array [3,1,4,1] for 3, it will go to index 2 and make its value negative ie. now nums[2] becomes -4. present array: [3,1,-4,1]
//for 1, it will go to index 0 and make its value negative ie. now nums[0] becomes -3. present array: [-3,1,-4,1]
//for 4, (take abs value), it will go to index 3 and make its value negative ie. now nums[3] becomes -1. present array: [-3,1,-4,-1]
//for 1 take abs value), it will go to index 0 as it is already -ve do nothing. present array: [-3,1,-4,-1]
//At last I will have [-3,1,-4,-1]. now i will iterate over the array, whichever idx has positive value that number will not be in the array so as we have nums[1]>0 so 2 is not in the list.

// 448. Find All Numbers Disappeared in an Array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
              result.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }

        return result; 
    }
}
