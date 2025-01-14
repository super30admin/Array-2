//Time complexity - O(N)
//Space complexity - O(1)

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    var n = nums.length;
    var arr = Array.from({length : n},(_,i)=>i+1);
    var list =[];
    for(let i of nums)
    {
        arr[i-1]=-1;
    }
    return arr.filter(i=>i>0);
    
};//