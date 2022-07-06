class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        //TC: O(N)
        //SC: O(N)
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            int diff = Math.abs(nums[i]) - 1;
            if(nums[diff] > 0) {
                nums[diff] = -1 * nums[diff];
            }
        }
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                al.add(i+1);
            } else {
                nums[i] = -1 * nums[i];
            }
        }
        
        return al;
        
        
        // TC: O(N)
        //SC: O(N)
//         HashSet<Integer> set = new HashSet<>();
//          for(int i=0;i<nums.length;i++) {
//             set.add(nums[i]);
//         }
        
//         for(int i=1;i<nums.length+1;i++) {
//             if(!set.contains(i)) {
//                 al.add(i);
//             } 
//         }
//         return al;
    }
}
