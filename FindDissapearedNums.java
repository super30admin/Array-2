class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> l = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

         for(int i=0;i<nums.length;i++){
           if(!set.contains(i+1))
            l.add(i+1);
        }
        return l;

    }
}