//448. Find All Numbers Disappeared in an Array Easy.java
 
/*
Time Complexity O(n)
Space Complexity O(1)
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i])-1;
            
            if(nums[newIndex] > 0)
                nums[newIndex] *= - 1;   
            
        }       
        for(int j = 0; j < nums.length;++j){
            if(nums[j] > 0)
                ans.add(j+1);
        }
        return ans;
    }
}
