public class FindDisappearedNumInArr {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }
        return result;
    }
}

// TC - O(n)
// SC - O(1)
