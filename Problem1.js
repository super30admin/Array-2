// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachß


/**
 * @param {number[]} nums
 * @return {number[]}
 */

 function findDisappearedNumbers(nums){
    let index = 0;
    while(index < nums.length){
        if(nums[index] === index + 1){
            // If current value is already in its position.
            index++;
        }else if(nums[index] === nums[nums[index] - 1]){
            // If we cannot do an exchange because they both have the same value.
            index++;
        }else{
            // Exchange numbers.
            exchange(nums, index, nums[index] - 1);
        }
    }
    
    let missingList = [];
    for(let i=0; i < nums.length; i++){
        // Count misplaced numbers.
        if(nums[i] !== i+1){ß
            missingList.push(i+1);
        }
    }
    
    return missingList;
}

function exchange(nums, i, j){
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
