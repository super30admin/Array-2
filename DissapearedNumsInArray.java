// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : could get with O(n) extra space but didn't get the intuition for O(1)
//modifying the input array seems a bit wierd

// Your code here along with comments explaining your approach
//This solution is to use the original array, mark nums[idx] as -ve if idx+1 num is present 
//finally return all idx+1's where nums[idx] is positive
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        int n;
        int idx;
    
        for(int i=0;i<nums.length;i++){
            n = Math.abs(nums[i]);
            idx = n-1;
            //we are marking nums[4] = -ve if 5 is found
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }
        
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0){
                result.add(i);
            }
        } 
        
        return result;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n), need extra array to keep track of what items were found
// Did this code successfully run on Leetcode : yes
// Your code here along with comments explaining your approach
//process nums array, maintain isFound array to keep track of what were found
//process all nums from 1 till nums.length, if not found add to result array list
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] isFound = new int[nums.length];
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int n: nums){
            isFound[n-1] = 1;
        }
        
        for(int i=1;i<=nums.length;i++){
            if(isFound[i-1]==0){
                result.add(i);
            }
        } 

        return result;
    }
}