#time complexity = O(n)
#space complexity = O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i =0 ; i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1]= -nums[Math.abs(nums[i])-1];
            }
        }
        
        List<Integer> l = new ArrayList<>();
        for(int i =0 ; i<nums.length;i++){
           if(nums[i]>0){
                l.add(i+1);
            }
        }
        return l;
        
    }
}
