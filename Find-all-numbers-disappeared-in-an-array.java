class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int m = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<m;j++){
            int x = Math.abs(nums[j]);
            int y = nums[x-1];
            if(y>0){
                nums[x-1] *= -1;
            }

        }
        for(int j=0;j<m;j++){
            if(nums[j]>0){
                list.add(j+1); //add the indices
            }else{
                nums[j] *= -1; //make the -ve elements as before to return as the original array
            }
        }
        return list;
    }
}