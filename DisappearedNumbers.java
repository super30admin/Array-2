// Time Complexity : O(n)
// Space Complexity : O(1) , no extra space other than the returning array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//To not take an extra space, we can negate the elements we have traversed using the value-1 as the index element
//the indices which has positive value will be returned with +1 to them

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Bruteforce with HashSet
        /*if(nums==null||nums.length==0) return new ArrayList<>();
        
        List<Integer> output=new ArrayList<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
            }
        }
        for(int i=1;i<=n;i++){
            if(!res.contains(i)){
                output.add(i);
            }
        }
        return output; */
        
        
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
         List<Integer> output=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
           
            int index=Math.abs(nums[i])-1;
             if(nums[index]>0){
            nums[index]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                output.add(i+1);
            }
        }
        return output;
    }
}