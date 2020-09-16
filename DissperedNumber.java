// Time Complexity : O(2n) = O(n)
//Space Complexity : O(1) used comutational datastructure hash set so i think the space doesnt count
//Did this code successfully run on Leetcode : Yes

// ----Dissapered number-----
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i ++){
        set.add(nums[i]);
    }
    
        for (int j = 1 ; j <= nums.length; j ++){
            if(!set.contains(j)){
                list.add(j);
            }
        }
    
    return list;
    }
}