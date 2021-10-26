// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> output = new ArrayList<>();
    if(nums == null || nums.length == 0) return output;
    
    //As the constarint mentions, the numbers will range from 1 to n, for every element
    // we calcultae the index and offset it by 1. Then we multiply the element at that index using -1 to
    //mark the element visited.
    for(int x: nums){
        int index = Math.abs(x) - 1;
        if(nums[index] > 0){
            nums[index] *= -1;
        }
    }
    //The visited elements would have a -ve sign. The positive elements indexes are the ones missing from
    //the array. we add +1 to adjust the offset
    for(int x = 0; x < nums.length; x++){
        if(nums[x] > 0){
            output.add(x + 1);
        }
    }
    return output;
}