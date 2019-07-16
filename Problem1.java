// Time Complexity : O(n)
// Space Complexity : O(n) + map space. ie.e O(n) 
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No , but the didnt get the approach.


// Your code here along with comments explaining your approach
        // thinking about the brut force.
        // binary search for missing element if the array is in sorted , i.e. O(log n)
        // Bitwise XOR for missing element if the array is in not sorted  , i.e. dont know.
        


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        

        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer,Integer> h = new HashMap<>();
        
        
        for(int i=0;i<nums.length;i++){
            
            if(h.containsKey(nums[i])){
                res.add(i);
            }else{
                h.put(nums[i],i);
            }
        }
        
        
        return res;
        
    }
}
