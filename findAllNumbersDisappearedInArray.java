/**
Time Complexity - O(N) Where N is the size of the array nums.
Space Complexity - O(1) output array size is not taken into consideration. 
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return null;
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                list.add(i + 1);

        return list;
    }
}
