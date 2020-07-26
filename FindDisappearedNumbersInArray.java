class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        Arrays.sort(nums);
        List<Integer> res = new ArrayList();
        
        int[] nums2 = new int[nums.length];
        
        for(int x : nums){
            nums2[x-1] = 1;
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i]==0){
                res.add(i+1);
            }
        }
    
        return res;
    }
}


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList();
        for(int x : nums){
            set.add(x);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
