//Time Complexity:O(n)
//Space Complexity:o(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(i+1);
        }
        for(int num:nums){
            set.remove(num);
        }
        for(int i:set){
            result.add(i);
        }
        return result;
    }
}
//Time Complexity:O(n)
//Space Complexity:o(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();
        List<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i])-1;
            if(nums[temp]>0)
                nums[temp]=-nums[temp];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}