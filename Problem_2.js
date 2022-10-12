// Time Complexity : 
// even length: O(3n/2)
// odd length: O(3n/2+1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes ran successfully locally
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
for linear search, time was 2n as 2 comparisions for each number
For finding via pairs: total comparisions = 3 for each pair
So TC 3n/2
*/

// let nums = [2,1,4,10,-1,0,50,20];
// let nums = [2,1,4,10,-1,0,50];
// let nums = [1,3]
// let nums = [2]
let len = nums.length;
let i = 0;
let max = -Infinity;
let min = Infinity;

if (len % 2 !== 0) {
    i = 1;
    min = nums[0];
    max = nums[0]
}

while (i < len - 1) {
    if (nums[i] > nums[i + 1]) {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i + 1]);
    } else {
        max = Math.max(max, nums[i + 1]);
        min = Math.min(min, nums[i]);
    }
    i += 2
}
console.log(max)
console.log(min);