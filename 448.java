class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        boolean[] flag=new boolean[nums.length+1];
        Set<Integer> set=new HashSet<>();
        
        for(int i=1;i<=nums.length;i++)
            set.add(i);
        
        for(int i=0;i<nums.length;i++)
            if(set.contains(nums[i]))
                flag[nums[i]]=true;
        
        for(int i=1;i<flag.length;i++)
            if(flag[i]==false)
                ans.add(i);

        return ans;
    }
}