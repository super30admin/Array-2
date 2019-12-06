// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. Key is to remember Math.abs operation though.

class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> disAppearedList = new ArrayList<>();
        
        if (nums.length==0 || nums== null) return disAppearedList;
        int index;
        for (int i=0;i<nums.length;i++) {
            
            index = Math.abs(nums[i]) - 1;
            
            if (nums[index] > 0) {
                nums[index] *= -1;    
            }
            
        }
        
        for (int i=0;i<nums.length;i++){
            if(nums[i]>0){
                disAppearedList.add(i+1);
            }
        }
        
        return disAppearedList;
    }
}