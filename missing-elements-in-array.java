// Time - O(N)
// Space - O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i])-1;
            
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=1;i<=nums.length;i++) {
            if(nums[i-1]>0) {
                result.add(i);
            }
        }
        
        return result;
    }
}
