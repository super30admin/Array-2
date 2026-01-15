/**
 * @param {number[]} nums
 * @return {number[]}
Intuition:
Since the array contains numbers from 1 to n and has length n, every value corresponds to a valid index in the array (value − 1). 
I am using the input array itself as a hash map by marking visited numbers as negative. For each number, we treat it's absolute value as a position and mark that index negative to indicate that this number exists.
After the first pass, any index that remains positive means its corresponding number (index + 1) was never seen in the array, so we add it to the result. This lets us find all missing numbers in O(n) time without extra space.
 */
var findDisappearedNumbers = function(nums) {
    // first pass
    for(let i = 0; i< nums.length; i++){
        const currNum = nums[i];
        const indexSupposedToBeIn = Math.abs(currNum)-1;
        if(nums[indexSupposedToBeIn] > 0) nums[indexSupposedToBeIn] *= -1; 
    }
    const result = [];
    // second pass
    for(let i = 0; i<nums.length;i++){
        if(nums[i]>0){
            result.push(i+1);
        }
    }
   return result;
};