// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// We will compare element with its next, and check which one is greater , for greater we will compare with max and for lesser we would compare with min

class Solution{
    
    public Pair findMaxMin(int[] nums){
        
    Pair p = new Pair();
        p.max = Integer.MIN_VALUE;
        p.min = Integer.MAX_VALUE;
            
            boolean isEven = nums.length %2 ==0;
        
        for(int i=0;i<nums.length-1;i=i+2){
            if(nums[i]>nums[i+1]){
                p.max = nums[i] > p.max ? nums[i] : p.max;
                p.min = nums[i+1] < p.min ? nums[i+1] : p.min;
            }else{
                p.min = nums[i] < p.min ? nums[i] : p.min;
                p.max = nums[i+1] > p.max ? nums[i+1] : p.max;
            }
        }
        
        if(!isEven){ // for odd length, last element would be left un compared
            if(nums[nums.length-1]>nums[nums.length-2]){
                p.max = nums[nums.length-1] > p.max ? nums[nums.length-1] : p.max;
                p.min = nums[nums.length-2] < p.min ? nums[nums.length-2] : p.min;
            }else{
                p.min = nums[nums.length-1] < p.min ? nums[nums.length-1] : p.min;
                p.max = nums[nums.length-2] > p.max ? nums[nums.length-2] : p.max;
            }
        }
        
        
        return p;
        
    }


}

class Pair{
    public int max;
    public int min;
}