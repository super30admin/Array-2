// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Accepted in LeetCode
// time complexity is O(n) and Space is O(n)

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    
    let set = new Set(nums)
    let result =[]
    for(let i=1;i<=nums.length;i++){
        if(!set.has(i)){
            result.push(i)
        }
    }
    return result
};