// Time Complexity : O(N) where N is length of array
// Space Complexity :O(1) as no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DisappearingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result= new ArrayList<>();
        
        if(nums.length==0) return result;
        for(int i=0;i<nums.length;i++){
            
            int idx=Math.abs(nums[i])-1; // get the index position -1 as array starts from 0
            if(nums[idx]>0) // if number at index is postive make it negative so that you can use index as a way to 
                                //keep track count of numbers in array. If it is already visited and negative then ignore
                nums[idx]*=-1;
            
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>0) result.add(i+1); // the numbers that end up positive will be the numbers which have disappeared. 
                                            //Since its an array add the index+1 to get the actual number that is missing
                
        }
        
        return result;
    }
}