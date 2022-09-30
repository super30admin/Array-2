// without using extra space

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        //make all nos at index nos that are present -ve
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = nums[index] * -1;
        }
        
        //find all +ve nos, the index+1 will give the nos that are missing
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}

//Time Complexity : O(n)
//Space Complexity :O(1)