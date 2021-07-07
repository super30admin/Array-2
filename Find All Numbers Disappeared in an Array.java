// time : n
// space : 1

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<Integer>(Collections.nCopies(nums.length+1,-1));

        for(int i=0 ; i<nums.length ; i++) ans.set(nums[i],nums[i]);

        for(int i=0 ; i<ans.size() ; i++)
        {
             if(ans.get(i) == -1) ans.set(i,i);
             else ans.set(i,-2);
        }

        ans.removeIf(p -> p<=0);

        return ans;

    }
}
