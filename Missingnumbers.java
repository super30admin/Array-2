class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ar=new ArrayList<>();
       
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);  
        
        }
        System.out.println(hs);
        for(int i=1;i<=nums.length;i++)
        {
            if(!hs.contains(i)) ar.add(i) ;
        
        }
        
        return ar;
        
    }
}
