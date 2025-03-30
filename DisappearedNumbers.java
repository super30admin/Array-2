class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length ; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}
