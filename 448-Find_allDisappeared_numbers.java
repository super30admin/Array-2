//Approach-1: Linear Search
//Approach-2: Sort the array and then find the missing elementsl
//Approach-3; Using the HashSet
//Approach-4: Using auxilary boolean array

//Approach-5: Temporary State Change (Currently used here)
//Overall Time Complexity: O(N)
//Overall Space Compplexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            if(nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] *= -1;
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) res.add(i+1);
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) nums[i] *= -1;
        }
        
        return res;
    }
}