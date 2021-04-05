class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 && nums == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        int temp;
        
        for(int i=0; i<nums.length;i++){
            temp = Math.abs(nums[i])-1;
            if(nums[temp]>0){
                nums[temp] = nums[temp]*-1;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}

//TC=> O(n)
//SC => O(1)
