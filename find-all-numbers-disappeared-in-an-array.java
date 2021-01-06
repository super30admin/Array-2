// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// multiply all position with -1 if element is available.
// All index with positive element are added to result.



public List<Integer> findDisappearedNumbers(int[] nums) {
    for(int i = 0; i< nums.length; i++){
        if(nums[Math.abs(nums[i])-1] >0){ nums[Math.abs(nums[i])-1] *= -1;}
    }
    List<Integer> result = new ArrayList<>();
    int j = 0;
    for(int i = 0; i< nums.length; i++){
        if(nums[i]>0) result.add(i+1);
    }
    return result;
}