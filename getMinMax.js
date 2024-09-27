// Time Complexity : O(n) where n is the length of nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var getMinMax = function(nums) {
    let min = Infinity;
    let max = -Infinity;
    
    for(let i=0; i<nums.length-2; i=i+2) {
        if(nums[i] > nums[i+1]) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i+1]);
        } else {
            max = Math.max(max,nums[i+1]);
            min = Math.min(min,nums[i]);
        }
    }
    if (nums.lenght % 2 !== 0) {
        max = Math.max(max,nums[nums.length - 1]);
        min = Math.min(min,nums[nums.length - 1]);
    }
    return [max,min];
}