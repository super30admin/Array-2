/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let map = new Map();
    let res = [];
    for(num of nums) {
        if(!map.get(num)) {
             map.set(num,1);
        }
    }

    for(let i = 0; i < nums.length; i++){
        if(map.get(i+1) === undefined) {
            res.push(i+1);
        }
    }
    return res;
};