// Time Complexity : o(n) Computations: (3*n/2) +2
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach



class MinMaxFromArray{ 
    public int[] getMinMax(int[] nums){
        if(nums == null || nums.length ==0){
            return new int[0];
        }
        
        int n= nums.length;
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        //dividing the array into pairs and checking and first comparing elements of each pair
        for(int i=0;i<n-1;i += 2){
            //the greater of the two elements need not be checked for min as it is already greater than an element 
            //Similarly smaller of the two elements need not be checked for max as it is already lesser than another element
            if(nums[i]>nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);               
            }
        }
        //if the length is odd, we will be left with one element at the end. we have to check that element for both min and max.
        if(n%2!=0){
            max = Math.max(max, nums[n-1]);
            min = Math.min(min, nums[n-1]);
        }
        return new int[]{min, max};
    }
}