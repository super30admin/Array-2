// Time Complexity :O(n) where n is no of elements
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class missingNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result  =  new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // math.abs - it can be negative, nums[i] - because we are going to that index, -1 - because my array ranges from 0 to n-1
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
                
            }
        }
        for (int i = 0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i +1 );
                
            }
        }
        return result;
    }
}   