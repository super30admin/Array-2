class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        // Mark numbers as visited by negating the corresponding index
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;  // Get correct index
            if (nums[index] > 0) {  // Mark only if not already marked
                nums[index] *= -1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}