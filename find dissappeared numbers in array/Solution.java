//Time complexity:O(n)
//space complexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length==0) return null;
        List<Integer> res = new ArrayList<>();
        int index;
        for(int i=0;i<nums.length;i++){
            index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *=-1;
            }
            }
         for(int i=0;i<nums.length;i++){
             if(nums[i]>0) res.add(i+1);
         }
        
    return res;
    }
}
