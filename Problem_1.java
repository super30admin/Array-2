class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashMap<Integer,Boolean> hmap = new HashMap<Integer,Boolean>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i],true);
            }
            
        }
      
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 1;i<=nums.length;i++){
            if(!hmap.containsKey(i)){
                result.add(i);
            }
        }
        return result;
    }
}

//Time Complexity: O(n) //we are iterating through the elements twice
//Space Complexity: O(n) 
