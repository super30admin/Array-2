// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var findDisappearedNumbers = function(nums) {
    let result = [];
    if(nums == null || nums.length == 0)return result;
    
    for(let i = 0; i < nums.length; i++){
        let idx = Math.abs(nums[i]) - 1;
        if(nums[idx] > 0){
            nums[idx] *= -1
        }
    }
    for(let i = 0; i < nums.length; i++){
        if(nums[i] > 0){
            result.push(i+1)
        }
        else {
            nums[i] *= -1
        }
    }
    return result
    
};