Time Complexity: O(n)
Space Complexity: Constant
Ran successfully on leetcode?: yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        int temp;
        for(int i = 0; i < nums.length; ++i){
        	int j = nums[i];
            while(j > 0 && nums[j-1] > 0){
            	temp = nums[j - 1];
                nums[j - 1] *= -1;
                j = temp;
            }
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        
        return list;
    }
}
