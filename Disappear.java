//Tme Complexity: O(n).
//Space Complexity: O(n).
//Any issues faced during execution: No



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        List<Integer> returnArr = new ArrayList<>();
        
        for(int i = 0; i < nums.length;i++){
            if(!numSet.contains(nums[i]))
                numSet.add(nums[i]);
        }
        
        
        for(int i = 1; i <= nums.length; i++){
            if(!numSet.contains(i))
                returnArr.add(i);
        }
        
        return returnArr;
    }
}