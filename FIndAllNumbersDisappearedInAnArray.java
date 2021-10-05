//Time Complexity: O(2*N)
//Space Complexity: O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> res = new HashSet<>();
        for(int i:nums){
            res.add(i);
        }
        for(int i=1;i<=nums.length;i++){
            if(res.contains(i)!=true){
                ans.add(i);
            }
        }
        return ans;
    }
}