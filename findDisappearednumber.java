// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],true);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=1; i<=nums.length; i++){
           
            if(!map.containsKey(i)){
                result.add(i);
            }
        }
        
        return result;
        
    }
}