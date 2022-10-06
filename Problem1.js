//Time: O(n), Space: O(1)
 var findDisappearedNumbers = function(nums) {
    let result = [];
    for(let i=0; i<nums.length; i++){
        let idx = Math.abs(nums[i]) - 1
        if(nums[idx] > 0 ){
            nums[idx] = nums[idx] * -1;
        }
    }
    for(let i=0; i<nums.length; i++){
        if(nums[i] > 0 ){
            result.push(i+1);
        }else{
            nums[i] = nums[i] * -1;
        }
    }
    return result;
};