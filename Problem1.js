//Find All Numbers Disappeared in an Array (LC 448)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

//Make numbers negative - marking them as visited if they are there and then push the missing numbers to result array

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let result=[];
    if(nums === null || nums.length === 0){
        return result;
    }
    for(let i=0;i<nums.length;i++){
        let ind = Math.abs(nums[i])-1;
        if(nums[ind] > 0){
            nums[ind] *= -1       
        }
    }
    for(let i=1;i<nums.length+1;i++){
        if(nums[i-1] > 0){
            result.push(i);
        }
    }
    return result;
};