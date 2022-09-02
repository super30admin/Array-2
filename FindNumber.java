class FindNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]) - 1;
            if (nums[num] > 0){
                nums[num] = 0 - nums[num];
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
        
    }
}